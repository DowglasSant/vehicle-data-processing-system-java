package com.vehicle.data.processing.system.enrichmentservice.component;

import com.vehicle.data.processing.system.enrichmentservice.model.Vehicle;
import com.vehicle.data.processing.system.enrichmentservice.service.VehicleEnrichmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    @Autowired
    private VehicleEnrichmentService vehicleEnrichmentService;

    @KafkaListener(topics = "${car.topic}", groupId = "enrichment-service-group")
    public void consumeCarMessages(ConsumerRecord<String, Vehicle> record) {
        try {
            vehicleEnrichmentService.enrichVehicle(record.value(), "car");
            log.info("Vehicle enrich successfully!");
        } catch (Exception e) {
            log.error("An exception occurred: " + e);
        }
    }

    @KafkaListener(topics = "${motobyke.topic}", groupId = "enrichment-service-group")
    public void consumeMotobykeMessages(ConsumerRecord<String, Vehicle> record) {
        try {
            vehicleEnrichmentService.enrichVehicle(record.value(), "motobyke");
            log.info("Vehicle enrich successfully!");
        } catch (Exception e) {
            log.error("An exception occurred: " + e);
        }
    }
}
