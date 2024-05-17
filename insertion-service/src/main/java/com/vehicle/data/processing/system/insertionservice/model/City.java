package com.vehicle.data.processing.system.insertionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("city")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
    private int id;
    private String name;
    private int stateId;
}
