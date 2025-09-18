package com.certicom.certifact_boletas_service_sp.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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

    private String codeResponse;
    private String descripcionResponse;
    private String userNameModify;
    private Timestamp fechaModificacion;
    private Integer intentosGetStatus;

}
