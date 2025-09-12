package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.BranchOfficeDto;
import com.certicom.certifact_boletas_service_sp.service.BranchOfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BranchOfficeController.API_PATH)
@RequiredArgsConstructor
public class BranchOfficeController {

    public static final String API_PATH = "/api/office";
    private final BranchOfficeService branchOfficeService;

    @GetMapping
    private ResponseEntity<BranchOfficeDto> obtenerOficina(
            @RequestParam Integer empresaId, @RequestParam String serie, @RequestParam String tipoComprobante
    ) {
        return new ResponseEntity<>(branchOfficeService.findByCompanyIdAndSerieAndTipoComprobante(empresaId, serie, tipoComprobante), HttpStatus.OK);
    }

}