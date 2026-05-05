package com.example.healthmonitoring.dto;

import java.time.Instant;

public record HealthResponse(
        String status,
        Instant timestamp
) {}
