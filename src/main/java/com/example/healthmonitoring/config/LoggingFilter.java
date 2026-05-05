package com.example.healthmonitoring.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String requestId = UUID.randomUUID().toString();

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        log.info("[{}] Incoming request: {} {}", requestId,
                httpRequest.getMethod(),
                httpRequest.getRequestURI());

        chain.doFilter(request, response);

        log.info("[{}] Response completed", requestId);
    }
}
