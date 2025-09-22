package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.dto.others.RucEstadoOther;
import com.certicom.certifact_boletas_service_sp.service.SummaryDocumentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SummaryDocumentsController.API_PATH)
@RequiredArgsConstructor
@Slf4j
public class SummaryDocumentsController {

    public static final String API_PATH = "/api/summary-documents";
    private final SummaryDocumentsService summaryDocumentsService;

    @GetMapping("/sequential-number")
    public ResponseEntity<Integer> getSequentialNumberInSummaryByFechaEmision(
            @RequestParam String rucEmisor, @RequestParam String fechaEmision) {
        return new ResponseEntity<>(summaryDocumentsService.getCorrelativoInSummary(rucEmisor, fechaEmision), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SummaryDto>  save(@RequestBody SummaryDto summaryDto) {
        return new ResponseEntity<>(summaryDocumentsService.save(summaryDto), HttpStatus.OK);
    }

    @GetMapping("/state-ruc")
    public ResponseEntity<List<RucEstadoOther>> getEstadoAndRucEmisorByNumeroTicket(@RequestParam String ticket) {
        return new ResponseEntity<>(summaryDocumentsService.getEstadoAndRucEmisorByNumeroTicket(ticket), HttpStatus.OK);
    }

    @GetMapping("/state")
    public ResponseEntity<String> getEstadoByNumeroTicket(@RequestParam String ticket) {
        return new ResponseEntity<>(summaryDocumentsService.getEstadoByNumeroTicket(ticket), HttpStatus.OK);
    }

    @GetMapping("/ticket")
    public ResponseEntity<SummaryDto> findByTicket(@RequestParam String ticket) {
        return new ResponseEntity<>(summaryDocumentsService.findByTicket(ticket), HttpStatus.OK);
    }

    @GetMapping("/id-document-summary")
    public ResponseEntity<Long> getIdDocumentSummaryByIdPaymentVoucher(@RequestParam Long idPaymentVoucher) {
        return new ResponseEntity<>(summaryDocumentsService.getIdDocumentSummaryByIdPaymentVoucher(idPaymentVoucher), HttpStatus.OK);
    }

}
