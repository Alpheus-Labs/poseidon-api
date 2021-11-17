package com.alpheus.poseidon.application.service.impl;

import com.alpheus.poseidon.application.request.SensorRequest;
import com.alpheus.poseidon.application.response.SensorResponse;
import com.alpheus.poseidon.application.service.SensorService;
import com.alpheus.poseidon.infraestructure.repository.SensorRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SensorServiceImpl implements SensorService {

    private SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public void saveSensorData(SensorRequest sensorRequest) {
        sensorRepository.save(sensorRequest.toSensorData());
    }

    public List<SensorResponse> findAllBy(UUID customerID) {
        var customerData = sensorRepository.findAllByCustomerId(customerID);

        return customerData.stream().map(SensorResponse::fromSensorData).collect(Collectors.toList());
    }

}
