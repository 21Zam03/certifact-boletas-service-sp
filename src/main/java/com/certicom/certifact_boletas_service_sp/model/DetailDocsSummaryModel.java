package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailDocsSummaryModel {

    private Long idDetailDocsSummary;
    private Long idDocsSummary;
    private Integer numeroItem;
    private String serieDocumento;
    private Integer numeroDocumento;
    private String tipoComprobante;
    private String tipDocIdentReceptor;
    private String numDocReceptor;
    private String serieAfectado;
    private Integer numeroAfectado;
    private String tipComprobAfectado;
    private Integer estadoItem;
    private BigDecimal importeTotalVenta;
    private BigDecimal sumatoriaOtroCargos;
    private BigDecimal totalOperExonerado;
    private BigDecimal totalOperExportacion;
    private BigDecimal totalOperGratuita;
    private BigDecimal totalOperGravada;
    private BigDecimal totalOperInafecta;
    private BigDecimal totalIgv;
    private BigDecimal totalIsc;
    private BigDecimal totalOtrosTrib;
    private String estado;

}
