package com.example.healthmonitoring.service;

import com.example.healthmonitoring.dto.MetricsResponse;
import com.example.healthmonitoring.util.SystemMetricsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetricsService {

    public MetricsResponse getMetrics() {
        log.info("Collecting system metrics");

        return new MetricsResponse(
                SystemMetricsUtil.getProcessCpuLoad(),
                SystemMetricsUtil.getSystemCpuLoad(),
                SystemMetricsUtil.getHeapUsed(),
                SystemMetricsUtil.getHeapMax(),
                SystemMetricsUtil.getNonHeapUsed(),
                SystemMetricsUtil.getNonHeapMax(),
                SystemMetricsUtil.getLoadAvg(0),
                SystemMetricsUtil.getLoadAvg(1),
                SystemMetricsUtil.getLoadAvg(2),
                SystemMetricsUtil.getYoungGcCount(),
                SystemMetricsUtil.getOldGcCount(),
                SystemMetricsUtil.getThreadCount(),
                SystemMetricsUtil.getUptime()
        );
    }
}
