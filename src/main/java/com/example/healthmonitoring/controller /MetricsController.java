package com.example.healthmonitoring.controller;

import com.example.healthmonitoring.dto.MetricsResponse;
import com.example.healthmonitoring.service.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class MetricsController {

    private final MetricsService metricsService;

    @GetMapping
    public MetricsResponse getMetrics() {
        return metricsService.getMetrics();
    }
}
