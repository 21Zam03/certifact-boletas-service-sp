package com.certicom.certifact_boletas_service_sp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class DataFilter implements Filter {

    public static final String X_RUC_CLIENT = "X-RUC-Client";
    public static final String X_ID_USER = "X-ID-User";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        long startTime = System.currentTimeMillis();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ruc = request.getHeader(X_RUC_CLIENT);
        String id = request.getHeader(X_ID_USER);

        if (ruc != null) {
            MDC.put("ruc", ruc);
        }

        if (id != null) {
            MDC.put("id", id);
        }

        try {
            log.info("Incoming request [{} {}]", request.getMethod(), request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("Completed request: duration={}ms", (System.currentTimeMillis() - startTime));
        } finally {
            MDC.clear();
        }
    }

}
