package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.service.PaymentCuotasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CuotaController.API_PATH)
@RequiredArgsConstructor
public class CuotaController {

    public static final String API_PATH = "/api/payment_cuotas";
    private final PaymentCuotasService cuotasPaymentVoucherService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deletePaymentCuotasById(@PathVariable("id") Long idCuota) {
        return new ResponseEntity<>(cuotasPaymentVoucherService.deletePaymentCuotasById(idCuota), HttpStatus.OK);
    }

}
