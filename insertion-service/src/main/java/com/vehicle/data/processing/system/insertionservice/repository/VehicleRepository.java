package com.vehicle.data.processing.system.insertionservice.repository;

import com.vehicle.data.processing.system.insertionservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public VehicleRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insertVehicle(Vehicle vehicle) {
        String collectionName = vehicle.getType() == 1 ? "cars" : "motos";
        mongoTemplate.save(vehicle, collectionName);
    }
}
