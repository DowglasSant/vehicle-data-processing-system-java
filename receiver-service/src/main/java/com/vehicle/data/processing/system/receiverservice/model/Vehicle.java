package com.vehicle.data.processing.system.receiverservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    private int type;
    private String licensePlate;
    private int year;
    private String ownerCPF;
    private String registrationCity;
    private String color;
    private String brand;
    private String model;
}
