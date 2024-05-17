package com.vehicle.data.processing.system.enrichmentservice.service;

import com.vehicle.data.processing.system.enrichmentservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${enriched.car.topic}")
    private String enrichedCarTopic;

    @Value("${enriched.motobyke.topic}")
    private String enrichedMotobykeTopic;

    public void produceMessage(Vehicle vehicle, String topicType) {
        String topic = topicType.equals("car") ? enrichedCarTopic : enrichedMotobykeTopic;
        kafkaTemplate.send(topic, vehicle.getLicensePlate(), vehicle);
    }
}
