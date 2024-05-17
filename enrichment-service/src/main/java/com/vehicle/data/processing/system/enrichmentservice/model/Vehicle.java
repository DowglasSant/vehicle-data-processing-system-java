package com.vehicle.data.processing.system.enrichmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private int type;

    private String licensePlate;

    private int year;

    private String ownerCPF;

    private String registrationCity;

    private String color;

    private String brand;

    private String model;

    private Manufacturer manufacturerInfo;

    private State stateInfo;
}
