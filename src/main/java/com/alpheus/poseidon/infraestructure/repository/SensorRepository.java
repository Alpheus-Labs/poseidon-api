package com.alpheus.poseidon.infraestructure.repository;

import com.alpheus.poseidon.domain.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SensorRepository extends JpaRepository<SensorData, Long> {

    public List<SensorData> findAllByCustomerId(UUID customerId);
}
