package com.vehicle.data.processing.system.insertionservice.component;

import com.vehicle.data.processing.system.insertionservice.model.Vehicle;
import com.vehicle.data.processing.system.insertionservice.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    @Autowired
    private VehicleService vehicleService;

    @KafkaListener(topics = "${enriched.car.topic}", groupId = "insertion-service-group")
    public void consumeCarMessages(ConsumerRecord<String, Vehicle> record) {
        try {
            vehicleService.insertVehicle(record.value());
            log.info("Vehicle inserted successfully!");
        } catch (Exception e) {
            log.error("An exception occurred: " + e);
        }
    }

    @KafkaListener(topics = "${enriched.motobyke.topic}", groupId = "insertion-service-group")
    public void consumeMotobykeMessages(ConsumerRecord<String, Vehicle> record) {
        try {
            vehicleService.insertVehicle(record.value());
            log.info("Vehicle inserted successfully!");
        } catch (Exception e) {
            log.error("An exception occurred: " + e);
        }
    }
}
