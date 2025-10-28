package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.service.HistorialStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HistorialStockController.API_PATH)
public class HistorialStockController {

    public final static String API_PATH = "/api/historial-stock";

    private HistorialStockService historialStockService;

    @DeleteMapping("/id-details-payment")
    public ResponseEntity<Integer> findOseByRucInter(@RequestParam Long idDetailsPayment) {
        return new ResponseEntity<>(historialStockService.deleteHistorialStockByIdDetailsPayment(idDetailsPayment), HttpStatus.OK);
    }

}
