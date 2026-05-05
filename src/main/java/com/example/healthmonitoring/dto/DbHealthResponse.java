package com.example.healthmonitoring.dto;

public record DbHealthResponse(
        String connection,
        Long latencyMs
) {}
