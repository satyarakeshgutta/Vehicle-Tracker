package io.egen.service;
import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertsRepo;
import io.egen.repository.ReadingsRepo;
import io.egen.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    AlertsRepo alertsRepo;

    @Override
    public List<Alerts> getAlerts() {
        List<Alerts> foundAlerts = alertsRepo.findAlerts();
        return foundAlerts;
    }

    @Override
    public List<Alerts> findAlerts(String vehicleId) {
        List<Alerts> foundAlertsbyId = alertsRepo.findAlertsbyId(vehicleId);
        return foundAlertsbyId;
    }

   /* @Autowired
    AlertsRepo alertsRepo;
    ReadingsRepo readingsRepo;
    VehicleRepo vehicleRepo;

    @Override
    @Transactional
    public void create(List<Readings> readings) {
        List<Alerts> alerts = new ArrayList<>();

        for(Readings r: readings){
            String vehicle_id = r.getVin();

            Readings readings_existing = readingsRepo.findbyVin(vehicle_id);
            Vehicle vehicle_existing = vehicleRepo.findbyVin(vehicle_id);

            //Checks for Alerts
            Alerts newalert = new Alerts();
            if(readings_existing!=null && vehicle_existing!=null){

                if(readings_existing.getEngineRpm()>vehicle_existing.getRedlineRpm()){
                    newalert.setPriority_RPM("HIGH");
                }
                if(readings_existing.getFuelVolume() <   (0.1 * vehicle_existing.getMaxFuelVolume()) ){
                    newalert.setPriority_fuelVolume("MEDIUM");
                }
                if (    (readings_existing.getTires().getFrontLeft() < 32 || readings_existing.getTires().getFrontLeft() >36 ) ||
                        (readings_existing.getTires().getFrontRight() < 32 || readings_existing.getTires().getFrontRight()>36) ||
                        (readings_existing.getTires().getRearLeft() < 32 || readings_existing.getTires().getRearLeft() >36)    ||
                        (readings_existing.getTires().getRearRight() < 32 || readings_existing.getTires().getRearRight() >36)
                        ) {

                    newalert.setPriority_tirePressure("LOW");
                }

                if(readings_existing.isCheckEngineLightOn()== true || readings_existing.isEngineCoolantLow()==true){
                    newalert.setPriority_engineStatus("LOW");
                }
            }
            alerts.add(newalert);
        }
        alertsRepo.create(alerts);*/
    }

