package com.alpheus.poseidon.infraestructure.repository;

import com.alpheus.poseidon.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Customer, UUID> {
}
