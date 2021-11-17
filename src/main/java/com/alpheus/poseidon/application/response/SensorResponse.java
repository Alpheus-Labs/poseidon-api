package com.alpheus.poseidon.application.response;

import com.alpheus.poseidon.domain.model.SensorData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorResponse {
    @JsonProperty(value = "sensor_name")
    private String sensorName;

    @JsonProperty(value = "value")
    private Long value;

    @JsonProperty(value = "is_valid")
    private Boolean isValid;

    @JsonProperty(value = "created_at")
    private LocalDate createdAt;

    @JsonProperty(value = "customer_id")
    private String customerId;

    public static SensorResponse fromSensorData(SensorData sensorData) {
        return SensorResponse.builder()
                .sensorName(sensorData.getSensorName())
                .value(sensorData.getValue())
                .isValid(sensorData.isValid())
                .createdAt(sensorData.getCreatedAt())
                .customerId(sensorData.getCustomer().getId().toString())
                .build();
    }
}
