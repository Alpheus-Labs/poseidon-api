package com.alpheus.poseidon.application.service;

import com.alpheus.poseidon.application.request.SensorRequest;
import com.alpheus.poseidon.application.response.SensorResponse;

import java.util.List;
import java.util.UUID;

public interface SensorService {

    public void saveSensorData(SensorRequest sensorRequest);

    public List<SensorResponse> findAllBy(UUID customerID);
}
