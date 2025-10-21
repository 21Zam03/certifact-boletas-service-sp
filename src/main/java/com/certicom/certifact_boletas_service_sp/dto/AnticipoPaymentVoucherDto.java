package com.certicom.certifact_boletas_service_sp.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AnticipoPaymentVoucherDto {

    private Long idAnticipoPayment;
    private Long idPaymentVoucher;
    private String identificadorPago;
    private String serieAnticipo;
    private Integer numeroAnticipo;
    private String tipoDocAnticipo;
    private BigDecimal montoAnticipo;

}
