package com.vehicle.data.processing.system.enrichmentservice.repository;

import com.vehicle.data.processing.system.enrichmentservice.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name);
}
