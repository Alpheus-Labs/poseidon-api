package com.alpheus.poseidon.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sensor_name")
    private String sensorName;

    @Column(name = "value")
    private Long value;

    @Column(name = "is_valid")
    private boolean isValid;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public SensorData(String sensorName, Long value, Boolean isValid, LocalDate createdAt, String customerId) {
        this.sensorName = sensorName;
        this.value = value;
        this.isValid = isValid;
        this.createdAt = createdAt;
        this.customer = new Customer(UUID.fromString(customerId), null, null, null);
    }
}
