package com.vehicle.data.processing.system.enrichmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String headquarters;

    @Column(name = "domestic_or_international")
    private String domesticOrInternational;

    @Column(name = "foundation_year")
    private int foundationYear;
}
