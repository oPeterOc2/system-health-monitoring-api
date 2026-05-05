package com.example.healthmonitoring.service;

import com.example.healthmonitoring.dto.DbHealthResponse;
import com.example.healthmonitoring.dto.HealthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthService {

    public HealthResponse getSystemHealth() {
        log.info("Checking system health");
        return new HealthResponse("OK", Instant.now());
    }

    public DbHealthResponse getDbHealth() {
        long start = System.currentTimeMillis();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb", "sa", "")) {

            try (PreparedStatement stmt = conn.prepareStatement("SELECT 1")) {
                stmt.executeQuery();
            }

            long latency = System.currentTimeMillis() - start;
            return new DbHealthResponse("UP", latency);

        } catch (Exception e) {
            return new DbHealthResponse("DOWN", -1L);
        }
    }
}
