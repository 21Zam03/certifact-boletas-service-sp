package com.certicom.certifact_boletas_service_sp.config;

import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleDeserializadorException(ServiceException ex) {
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .code("SERVICE_EXCEPTION_ERROR")
                .message(ex.getMessage())
                .build());
    }

}
