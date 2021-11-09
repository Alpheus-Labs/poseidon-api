package com.alpheus.poseidon.infraestructure.repository;

import com.alpheus.poseidon.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UUID, User> {
}
