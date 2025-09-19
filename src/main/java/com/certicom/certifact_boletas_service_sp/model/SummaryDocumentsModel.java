package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummaryDocumentsModel {

    private Long idDocumentSummary;
    private String codeResponse;
    private Integer correlativoDia;
    private String descriptionResponse;
    private String estado;
    private String estadoDocumento;
    private String fechaEmision;
    private String fechaGeneracion;
    private Timestamp fechaGeneracionResumen;
    private Timestamp fechaModificacion;
    private String idDocument;
    private String rucEmisor;
    private String ticketSunat;
    private String userName;
    private String userNameModify;
    private Integer intentosGetStatus;

}
