package com.vehicle.data.processing.system.enrichmentservice.repository;

import com.vehicle.data.processing.system.enrichmentservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
