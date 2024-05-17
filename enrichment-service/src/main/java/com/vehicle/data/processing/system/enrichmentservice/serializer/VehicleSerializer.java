package com.vehicle.data.processing.system.enrichmentservice.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.data.processing.system.enrichmentservice.model.Vehicle;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class VehicleSerializer implements Serializer<Vehicle> {

    private static final Logger logger = LoggerFactory.getLogger(VehicleSerializer.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Vehicle data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            logger.error("Error while serializing vehicle data: ", e);
            throw new IllegalStateException("Error while serializing vehicle data", e);
        }
    }

    @Override
    public void close() {
    }
}
