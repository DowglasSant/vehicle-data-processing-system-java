package com.vehicle.data.processing.system.enrichmentservice.serializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.data.processing.system.enrichmentservice.model.Vehicle;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class VehicleDeserializer implements Deserializer<Vehicle> {

    private static final Logger logger = LoggerFactory.getLogger(VehicleDeserializer.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Vehicle deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                logger.info("Null received at deserializing");
                return null;
            }
            return objectMapper.readValue(data, Vehicle.class);
        } catch (Exception e) {
            logger.error("Error deserializing data {}", new String(data), e);
            throw new IllegalArgumentException("Error deserializing data", e);
        }
    }

    @Override
    public void close() {
    }
}
