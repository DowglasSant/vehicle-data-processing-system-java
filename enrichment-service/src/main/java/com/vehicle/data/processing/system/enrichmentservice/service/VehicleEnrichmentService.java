package com.vehicle.data.processing.system.enrichmentservice.service;

import com.vehicle.data.processing.system.enrichmentservice.model.City;
import com.vehicle.data.processing.system.enrichmentservice.model.Manufacturer;
import com.vehicle.data.processing.system.enrichmentservice.model.State;
import com.vehicle.data.processing.system.enrichmentservice.model.Vehicle;
import com.vehicle.data.processing.system.enrichmentservice.repository.CityRepository;
import com.vehicle.data.processing.system.enrichmentservice.repository.ManufacturerRepository;
import com.vehicle.data.processing.system.enrichmentservice.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleEnrichmentService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public void enrichVehicle(Vehicle vehicle, String topicType) throws Exception {
        Manufacturer manufacturer = manufacturerRepository.findByName(vehicle.getBrand());
        if (manufacturer == null) {
            throw new Exception("Manufacturer not found");
        }
        vehicle.setManufacturerInfo(manufacturer);

        City city = cityRepository.findByName(vehicle.getRegistrationCity());
        if (city == null) {
            throw new Exception("City not found");
        }
        State state = city.getState();
        vehicle.setStateInfo(state);

        kafkaProducerService.produceMessage(vehicle, topicType);
    }
}