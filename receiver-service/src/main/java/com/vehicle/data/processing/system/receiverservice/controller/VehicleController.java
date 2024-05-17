package com.vehicle.data.processing.system.receiverservice.controller;

import com.vehicle.data.processing.system.receiverservice.model.Vehicle;
import com.vehicle.data.processing.system.receiverservice.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
@Slf4j
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/receive")
    public ResponseEntity<String> handleVehicleReceived(@RequestBody Vehicle vehicle) {
        try {
            vehicleService.processVehicleData(vehicle);
            return new ResponseEntity<>("Vehicle data processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erro: " + e);
            return new ResponseEntity<>("Failed to process vehicle data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
