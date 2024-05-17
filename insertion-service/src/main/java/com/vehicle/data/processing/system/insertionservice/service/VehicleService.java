package com.vehicle.data.processing.system.insertionservice.service;

import com.vehicle.data.processing.system.insertionservice.model.Vehicle;
import com.vehicle.data.processing.system.insertionservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void insertVehicle(Vehicle vehicle) {
        vehicle.setInsertionTime(Timestamp.from(Instant.now()));
        vehicleRepository.insertVehicle(vehicle);
    }
}
