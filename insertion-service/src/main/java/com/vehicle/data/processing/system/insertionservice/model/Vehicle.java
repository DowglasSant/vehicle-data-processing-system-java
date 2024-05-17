package com.vehicle.data.processing.system.insertionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "vehicles")
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
    private Manufacturer manufacturerInfo;
    private State stateInfo;
    private Timestamp insertionTime;
}
