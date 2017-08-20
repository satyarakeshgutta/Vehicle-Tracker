package io.egen.service;

import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertsRepo;
import io.egen.repository.ReadingsRepo;
import io.egen.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    private ReadingsRepo readingsRepo;
    @Autowired
    private AlertsRepo alertsRepo;
    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    @Transactional
    public void create(Readings readings) {

        String vehicle_id = readings.getVin();
        Vehicle vehicle_existing = vehicleRepo.findbyVin(vehicle_id);
        List<Alerts> foundAlerts = new ArrayList<>();
        if(vehicle_existing!=null) {
            foundAlerts = createAlerts(readings,vehicle_existing);
        }
        for(Alerts a :foundAlerts) {
            alertsRepo.create(a);
        }
        readingsRepo.create(readings);
    }



    public  List<Alerts> createAlerts( Readings r,Vehicle vehicle_existing){

            List<Alerts> alerts = new ArrayList<>();
            //Checks for Alerts
                Alerts newalert = new Alerts();
                newalert.setVehicleId(vehicle_existing.getVin());
                newalert.setAlertTime(Calendar.getInstance().getTime().toString());
                if(r.getEngineRpm()>vehicle_existing.getRedlineRpm()){
                    newalert.setPriority_RPM("HIGH");
                }
                else newalert.setPriority_RPM("NORMAL");
                if(r.getFuelVolume() <   (0.1 * vehicle_existing.getMaxFuelVolume()) ){
                    newalert.setPriority_fuelVolume("MEDIUM");
                }
                else newalert.setPriority_fuelVolume("NORMAL");
                if (    (r.getTires().getFrontLeft() < 32 || r.getTires().getFrontLeft() >36 ) ||
                        (r.getTires().getFrontRight() < 32 || r.getTires().getFrontRight()>36) ||
                        (r.getTires().getRearLeft() < 32 || r.getTires().getRearLeft() >36)    ||
                        (r.getTires().getRearRight() < 32 || r.getTires().getRearRight() >36)
                        ) {

                    newalert.setPriority_tirePressure("LOW");
                }
                else newalert.setPriority_tirePressure("NORMAL");
                if(r.isCheckEngineLightOn()== true || r.isEngineCoolantLow()==true){
                    newalert.setPriority_engineStatus("LOW");
                }
                else newalert.setPriority_engineStatus("NORMAL");
                alerts.add(newalert);

        return alerts;
    }

    @Override
    public List<Readings> getReadings() {
        return readingsRepo.getAllReadings();
    }

    @Override
    public List<Readings> findById(String vId) {
        return readingsRepo.getReadingsById(vId);
    }
}
