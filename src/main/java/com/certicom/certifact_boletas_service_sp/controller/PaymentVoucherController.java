package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(PaymentVoucherController.API_PATH)
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherController {

    public static final String API_PATH = "/api/payment-voucher";
    private final PaymentVoucherService paymentVoucherService;

    @PostMapping
    public ResponseEntity<PaymentVoucherDto> savePaymentVoucher(@RequestBody PaymentVoucherDto paymentVoucherDto) {
        log.info("OBJECT: {}", paymentVoucherDto);
        return new ResponseEntity<>(paymentVoucherService.save(paymentVoucherDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updatePaymentVoucher(@RequestBody PaymentVoucherDto paymentVoucherDto) {
      return new ResponseEntity<>(paymentVoucherService.update(paymentVoucherDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaymentVoucher(@PathVariable Long id) {
        return new ResponseEntity<>(paymentVoucherService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/id-document")
    public ResponseEntity<PaymentVoucherDto> findByIdentificadorDocumento(@RequestParam String identificadorDocumento) {
        return new ResponseEntity<>(paymentVoucherService.findByIdentificadorDocumento(identificadorDocumento), HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<Integer> getNumeracion(@RequestParam String tipoComprobante, @RequestParam String serie, @RequestParam String ruc) {
        return new ResponseEntity<>(paymentVoucherService.getNumeracion(tipoComprobante, serie, ruc) ,HttpStatus.OK);
    }

    @GetMapping("/specific-summary")
    public ResponseEntity<List<PaymentVoucherDto>> findListSpecificForSummary(
            @RequestParam String rucEmisor, @RequestParam String fechaEmision,
            @RequestParam String tipo, @RequestParam String serie, @RequestParam Integer numero
    ) {
        return new ResponseEntity<>(paymentVoucherService.findListSpecificForSummary(rucEmisor, fechaEmision, tipo, serie, numero), HttpStatus.OK);
    }

    @GetMapping("/summary-ruc-date")
    public ResponseEntity<List<PaymentVoucherDto>> findAllForSummaryByRucEmisorAndFechaEmision(
            @RequestParam String rucEmisor, @RequestParam String fechaEmision) {
        return new ResponseEntity<>(paymentVoucherService.findAllForSummaryByRucEmisorAndFechaEmision(rucEmisor, fechaEmision), HttpStatus.OK);
    }

    @PutMapping("/state")
    public ResponseEntity<Integer> updateStateToSendSunatForSummaryDocuments(
            @RequestParam List<Long> ids, @RequestParam String usuario, @RequestParam Timestamp fechaModificacion) {
        return new ResponseEntity<>(paymentVoucherService.updateStateToSendSunatForSummaryDocuments(ids, usuario, fechaModificacion), HttpStatus.OK);
    }

    @PutMapping("/payment-summary")
    public ResponseEntity<?> updateComprobantesBySummaryDocuments(
            @RequestParam List<String> comprobantesByAceptar,
            @RequestParam String codigo,
            @RequestParam String abreviado,
            @RequestParam String usuario,
            @RequestParam Timestamp fechaModificacion) {
        return new ResponseEntity<>(paymentVoucherService.updateComprobantesBySummaryDocuments(comprobantesByAceptar, codigo, abreviado, usuario, fechaModificacion), HttpStatus.OK);
    }
}
