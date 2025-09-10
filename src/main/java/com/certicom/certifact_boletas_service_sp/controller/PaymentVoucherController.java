package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PaymentVoucherController.API_PATH)
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherController {

    public static final String API_PATH = "/api/payment-voucher";
    private final PaymentVoucherService paymentVoucherService;

    @PostMapping
    public ResponseEntity<?> savePaymentVoucher(@RequestBody PaymentVoucherDto paymentVoucherDto) {
        return new ResponseEntity<>(paymentVoucherService.save(paymentVoucherDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updatePaymentVoucher() {
      return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deletePaymentVoucher() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
