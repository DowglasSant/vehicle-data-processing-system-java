package com.vehicle.data.processing.system.enrichmentservice.repository;

import com.vehicle.data.processing.system.enrichmentservice.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
