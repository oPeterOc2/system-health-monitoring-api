package com.example.healthmonitoring.controller;

import com.example.healthmonitoring.dto.HealthResponse;
import com.example.healthmonitoring.dto.DbHealthResponse;
import com.example.healthmonitoring.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    public HealthResponse getSystemHealth() {
        return healthService.getSystemHealth();
    }

    @GetMapping("/db")
    public DbHealthResponse getDbHealth() {
        return healthService.getDbHealth();
    }
}
