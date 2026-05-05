package com.example.healthmonitoring.dto;

public record MetricsResponse(
        double processCpuLoad,
        double systemCpuLoad,
        long heapUsed,
        long heapMax,
        long nonHeapUsed,
        long nonHeapMax,
        double loadAvg1m,
        double loadAvg5m,
        double loadAvg15m,
        long youngGcCount,
        long oldGcCount,
        int threadCount,
        long uptime
) {}
