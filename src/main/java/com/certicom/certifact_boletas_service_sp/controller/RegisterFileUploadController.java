package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.RegisterFileUploadDto;
import com.certicom.certifact_boletas_service_sp.service.RegisterFileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RegisterFileUploadController.API_PATH)
@RequiredArgsConstructor
public class RegisterFileUploadController {

    public final static String API_PATH = "/api/register-file-upload";

    private final RegisterFileUploadService registerFileUploadService;

    @PostMapping
    private ResponseEntity<RegisterFileUploadDto> registrarArchivo(@RequestBody RegisterFileUploadDto registerFileUpload) {
        return new ResponseEntity<>(registerFileUploadService.save(registerFileUpload), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<RegisterFileUploadDto> findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc
            (@RequestParam Long idPayment, @RequestParam String tipoArchivo, @RequestParam String estadoArchivo) {
        return new ResponseEntity<>(
                registerFileUploadService.findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(idPayment, tipoArchivo, estadoArchivo),
                HttpStatus.OK
        );
    }

    @GetMapping("/id&uuid&tipo")
    public ResponseEntity<RegisterFileUploadDto> findByIdPaymentVoucherAndUuidTipo(@RequestParam Long id, @RequestParam String uuid, @RequestParam String tipo) {
        return new ResponseEntity<>(registerFileUploadService.findByIdPaymentVoucherAndUuidTipo(id, uuid, tipo), HttpStatus.OK);
    }

}
