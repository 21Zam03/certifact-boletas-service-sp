package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.service.AnticipoPaymentVoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AnticipoController.API_PATH)
@RequiredArgsConstructor
public class AnticipoController {

    public static final String API_PATH = "/api/anticipo";
    private final AnticipoPaymentVoucherService anticipoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAnticipoById(@PathVariable("id") Long anticipoId) {
        return new ResponseEntity<>(anticipoService.deleteAnticipoPaymentVoucherById(anticipoId), HttpStatus.OK);
    }

}
