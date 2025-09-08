package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.request.PaymentVoucherRequest;
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
    public ResponseEntity<?> savePaymentVoucher(@RequestBody PaymentVoucherRequest paymentVoucherRequest) {
        return new ResponseEntity<>(paymentVoucherService.save(paymentVoucherRequest), HttpStatus.OK);
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
