package com.alpheus.poseidon.application.request;

import com.alpheus.poseidon.domain.model.SensorData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorRequest {

    @JsonProperty(value = "sensor_name")
    private String sensorName;

    @JsonProperty(value = "value")
    private Long value;

    @JsonProperty(value = "is_valid")
    private Boolean isValid;

    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "Date format: yyyy-mm-dd")
    @JsonProperty(value = "created_at")
    private LocalDate createdAt;

    @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}",
            message = "Customer ID must be an UUID")
    @JsonProperty(value = "customer_id")
    private String customerId;

    public SensorData toSensorData() {
        return new SensorData(this.sensorName, this.value, this.isValid,
                this.createdAt, this.customerId);
    }
}
