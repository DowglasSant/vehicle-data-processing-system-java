package com.vehicle.data.processing.system.receiverservice.service;

import com.vehicle.data.processing.system.receiverservice.kafka.KafkaPublisher;
import com.vehicle.data.processing.system.receiverservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final KafkaPublisher kafkaPublisher;

    @Value("${car.topic}")
    private String carTopic;

    @Value("${motobyke.topic}")
    private String motobykeTopic;

    public VehicleService(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    public void processVehicleData(Vehicle vehicle) {
        String topic;
        if (vehicle.getType() == 1) {
            topic = carTopic;
        } else if (vehicle.getType() == 2) {
            topic = motobykeTopic;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
        kafkaPublisher.publish(topic, vehicle.getLicensePlate(), vehicle);
    }
}
