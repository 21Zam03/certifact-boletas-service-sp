package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummaryFileModel {

    private Long id;
    private String estadoArchivo;
    private Integer orden;
    private String tipoArchivo;
    private Long idRegisterFileSend;
    private Long idDocumentSummary;

}
