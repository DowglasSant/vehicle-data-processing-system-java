package com.vehicle.data.processing.system.insertionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("state")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class State {
    private Long id;

    private String name;
}
