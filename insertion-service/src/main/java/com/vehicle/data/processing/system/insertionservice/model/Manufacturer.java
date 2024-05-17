package com.vehicle.data.processing.system.insertionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "manufacturers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Manufacturer {
    private int id;
    private String name;
    private String headquarters;
    private String domesticOrInternational;
    private int foundationYear;
}
