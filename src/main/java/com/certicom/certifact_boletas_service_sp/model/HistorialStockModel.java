package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialStockModel {

    private Long idHistorialStock;
    private LocalDateTime fechaDeActualizacion;
    private Long variacionStock;
    private Long stockAntes;
    private Long stockDespues;
    private String evento;
    private Long productId;
    private Long idUser;
    private Long compraSeq;
    private Long idPaymentVoucher;
    private Long idGuiaRemision;
    private Long idCotizacion;
    private Long idDetailsPayment;
    private Long idDetailsGuia;
    private Long idDetailsCoti;

}
