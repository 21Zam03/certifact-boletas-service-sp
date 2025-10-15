package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.service.AditionalFieldPaymentVoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AditionalFieldController.API_PATH)
@RequiredArgsConstructor
public class AditionalFieldController {

    public final static String API_PATH = "/api/aditional-field-payment-voucher";

    private final AditionalFieldPaymentVoucherService aditionalFieldService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAditionalFieldPaymentById(@PathVariable("id") Long aditionalPaymentId) {
        return new ResponseEntity<>(aditionalFieldService.deleteAditionalFieldPaymentVoucherService(aditionalPaymentId), HttpStatus.OK);
    }

}
