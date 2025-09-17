package com.certicom.certifact_boletas_service_sp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummaryDto {

    private String fechaEmision;
    private Integer nroResumenDelDia;
    private List<SummaryDetailDto> items;

    private String rucEmisor;
    private String denominacionEmisor;
    private String nombreComercialEmisor;
    private String tipoDocumentoEmisor;

    private String estadoComprobante;

    private String idDocument;
    private String estado;
    private String fechaGeneracion;
    private Timestamp fechaGereracionResumen;
    private String ticketSunat;
    private String userName;
    private List<SummaryFileDto> summaryFileDtoList;

}
