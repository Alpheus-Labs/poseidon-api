package com.alpheus.poseidon.infraestructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok().body("Pong!");
    }
}
