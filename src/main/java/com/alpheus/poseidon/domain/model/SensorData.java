package com.alpheus.poseidon.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sensor_date")
public class SensorData {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private int id;

    @Column(name = "sensor_name")
    private String sensorName;

    @Column(name = "value")
    private Long value;

    @ManyToOne
    @JoinColumn(name = "id")
    private User userId;
}
