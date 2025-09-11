package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.CompanyDto;
import com.certicom.certifact_boletas_service_sp.dto.OseDto;
import com.certicom.certifact_boletas_service_sp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CompanyController.API_PATH)
public class CompanyController {

    public final static String API_PATH = "/api/company";
    private final CompanyService companyService;

    @GetMapping("/state")
    private ResponseEntity<String> obtenerEstadoEmpresaPorRuc(@RequestParam String rucEmisor) {
        return new ResponseEntity<>(companyService.getEstadoByRuc(rucEmisor), HttpStatus.OK);
    }

    @GetMapping("/{ruc}")
    private ResponseEntity<CompanyDto> obtenerEmpresaPorRuc(@PathVariable String ruc) {
        return new ResponseEntity<>(companyService.findByRuc(ruc), HttpStatus.OK);
    }

    @GetMapping("/api/company/ose")
    public ResponseEntity<OseDto> findOseByRucInter(@RequestParam String ruc) {
        return new ResponseEntity<>(companyService.findOseByRuc(ruc), HttpStatus.OK);
    }

}
