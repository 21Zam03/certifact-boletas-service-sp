package com.certicom.certifact_boletas_service_sp.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Slf4j
@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
    public static final String REQUEST_ID_HEADER = "X-Request-Id";
    public static final String TRACE_ID = "X-B3-TraceId";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        long startTime = System.currentTimeMillis();

        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        String requestId = request.getHeader(REQUEST_ID_HEADER);

        System.out.println("TEST HEADER"+ request.getHeader(TRACE_ID));
        log.info("🔍 [HEADERS ENTRANTES]");
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                log.info("{}: {}", headerName, headerValue);
            }
        }

        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }

        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }

        // Añadimos a MDC para logs
        MDC.put("correlationId", correlationId);
        MDC.put("requestId", requestId);

        // Añadir a la respuesta HTTP también
        response.setHeader(CORRELATION_ID_HEADER, correlationId);
        response.setHeader(REQUEST_ID_HEADER, requestId);

        try {
            log.info("Incoming request [{} {}]", request.getMethod(), request.getRequestURI());
            filterChain.doFilter(request, response);
            log.info("✅  Completed request: status={} duration={}ms",
                    response.getStatus(),
                    (System.currentTimeMillis() - startTime)
            );
        } finally {
            MDC.clear();
        }
    }

}
