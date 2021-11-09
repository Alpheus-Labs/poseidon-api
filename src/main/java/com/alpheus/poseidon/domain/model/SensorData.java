package com.alpheus.poseidon.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sensor_date")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sensor_name")
    private String sensorName;

    @Column(name = "value")
    private Long value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
}
