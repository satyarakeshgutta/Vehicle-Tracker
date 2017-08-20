package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    @Transactional
    public void createOrUpdate(List<Vehicle> vehicle) {
        List<Vehicle> updateVehicleList = new ArrayList<>();
        List<Vehicle> createVehicleList = new ArrayList<>();
        int l = vehicle.size();

        for (Vehicle v : vehicle) {
            String vehicle_id = v.getVin();
            Vehicle existing = vehicleRepo.findbyVin(vehicle_id);
            if (existing != null) {
                updateVehicleList.add(v);
            }
            else createVehicleList.add(v);
        }

        if (createVehicleList.size() > 0 && createVehicleList.size() < l) {
            vehicleRepo.create(createVehicleList);
            vehicleRepo.update(updateVehicleList);
        }
        if (createVehicleList.size() == 0) {
            vehicleRepo.update(updateVehicleList);
        }
        if (createVehicleList.size() == l) {
            vehicleRepo.create(createVehicleList);
        }
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehiclesFound = vehicleRepo.findAll();
        return vehiclesFound;
    }

    @Override
    public Vehicle findOne(String vehicleId) {
        Vehicle v = vehicleRepo.findbyVin(vehicleId);
        return v;
    }

    @Override
    public void delete(String vehicleId) {

    }

}
