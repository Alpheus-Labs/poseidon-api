package com.alpheus.poseidon.infraestructure.controller;

import com.alpheus.poseidon.application.response.SensorResponse;
import com.alpheus.poseidon.application.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<SensorResponse>> getAllDataBy(@RequestParam("userID") String userID) {
        var sensorData = sensorService.findAllBy(UUID.fromString(userID));

        if (sensorData.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(sensorData);
    }
}
