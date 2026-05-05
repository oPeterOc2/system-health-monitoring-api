# System Health Monitoring API

A production-style Spring Boot 3 backend service that exposes system health, database latency, and JVM metrics APIs.  
Designed as a portfolio-ready project to demonstrate backend engineering practices, observability, and CI integration.

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Build](https://github.com/oPeterOc2/system-health-monitoring-api/actions/workflows/ci.yml/badge.svg)

## Overview

System Health Monitoring API is a lightweight, production‑style backend service built with Spring Boot 3.  
It provides real‑time system health information, database latency checks, and detailed JVM metrics.  
The project is designed to demonstrate backend engineering fundamentals, observability, testing, and CI automation.

---

## Features

- **Health Endpoints**
  - `/health` – Basic system status
  - `/health/db` – Real database latency using H2 in‑memory DB

- **Metrics Endpoint**
  - `/metrics` – JVM and system metrics including:
    - CPU usage (process & system)
    - Heap / Non‑heap memory
    - Load average
    - GC counts (Young / Old)
    - Thread count
    - Uptime

- **Engineering Practices**
  - Global exception handling
  - Request logging filter with correlation ID
  - Layered architecture (Controller / Service / DTO / Util)
  - Unit tests (MockMvc + Service tests)
  - GitHub Actions CI (Maven clean verify)

---
## Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Maven**
- **H2 Database (in‑memory)**
- **JUnit 5 + MockMvc**
- **GitHub Actions (CI)**
- **Lombok**
- **SLF4J Logging**

## Architecture

The project follows a clean, layered architecture:
<pre>
controller/        → REST endpoints
service/           → Business logic
dto/               → API response models
util/              → System & JVM metric utilities
exception/         → Global exception handling
filter/            → Request logging with correlation ID
</pre>

This structure keeps the codebase maintainable, testable, and production‑ready.

## Setup & Run

### Prerequisites
- Java 21
- Maven (or use the included Maven Wrapper)
- GitHub Codespaces / local environment

---

### Run in Codespaces

The project includes the Maven Wrapper, so you can run it directly:
<pre>
./mvnw spring-boot:run
</pre>

The API will start on:
<pre>
http://localhost:8080
</pre>

---

### Run Locally

If running outside Codespaces:
<pre>
mvn clean install
mvn spring-boot:run
</pre>

---

### Run Tests
<pre>
./mvnw test
</pre>

All unit tests (MockMvc + Service tests) will be executed automatically.

## API Endpoints

### Health Endpoints

#### `GET /health`
Returns basic system status.

Example response:
<pre>
{
  "status": "UP",
  "timestamp": "2024-01-01T12:00:00Z"
}
</pre>

---

#### `GET /health/db`
Measures real database latency using H2 in‑memory DB.

Example response:
<pre>
{
  "database": "H2",
  "latencyMs": 3,
  "status": "UP"
}
</pre>

### Metrics Endpoint

#### `GET /metrics`
Returns detailed JVM and system metrics including CPU usage, memory usage, GC counts, thread count, and uptime.

Example response:
<pre>
{
  "cpu": {
    "processCpuLoad": 0.12,
    "systemCpuLoad": 0.35
  },
  "memory": {
    "heapUsed": 134217728,
    "heapCommitted": 268435456,
    "nonHeapUsed": 45219840
  },
  "gc": {
    "youngGcCount": 5,
    "oldGcCount": 1
  },
  "threads": {
    "threadCount": 22
  },
  "system": {
    "loadAverage": 1.42,
    "uptimeMs": 1234567
  }
}
</pre>

## Project Structure

<pre>
src/
 └── main/
      ├── java/com/example/health/
      │     ├── controller/      → REST endpoints
      │     ├── service/         → Business logic
      │     ├── dto/             → Response models
      │     ├── util/            → System & JVM metric utilities
      │     ├── exception/       → Global exception handling
      │     └── filter/          → Request logging filter
      │
      └── resources/
            └── application.properties
</pre>

## Why Not Use Spring Boot Actuator?

This project intentionally does not use Spring Boot Actuator for `/health` and `/metrics`.  
Instead, all endpoints are implemented manually to demonstrate backend engineering skills.

### Advantages of Custom Implementation
- **Full control of response structure**  
  Allows tailoring the JSON format to match real production requirements.

- **Demonstrates engineering fundamentals**  
  Shows understanding of JVM metrics, GC, CPU load, thread usage, and system monitoring.

- **No hidden abstractions**  
  Everything is explicit—useful for interviews and code reviews.

- **Lightweight**  
  Avoids exposing unnecessary Actuator endpoints in small services.

### Disadvantages Compared to Actuator
- **More code to maintain**  
  Actuator provides many metrics out of the box; custom code requires updates.

- **Missing advanced metrics**  
  Actuator includes thread dumps, heap dumps, environment info, etc.

- **Less integration with monitoring tools**  
  Actuator integrates natively with Prometheus, Micrometer, and Grafana.

- **Reinventing the wheel for production**  
  In real systems, Actuator is usually preferred for completeness and reliability.

## Future Improvements

Planned enhancements to further improve the project:

- **Add Docker support**  
  Containerize the application for consistent deployment.

- **Add Prometheus + Grafana integration**  
  Export metrics for real‑time dashboards and alerting.

- **Add database connection pool metrics**  
  Monitor HikariCP usage and performance.

- **Add more unit tests & integration tests**  
  Increase coverage for service and error‑handling layers.

- **Add API rate limiting**  
  Protect endpoints using a lightweight rate‑limit filter.

- **Add OpenAPI / Swagger documentation**  
  Auto‑generate API docs for easier onboarding.
