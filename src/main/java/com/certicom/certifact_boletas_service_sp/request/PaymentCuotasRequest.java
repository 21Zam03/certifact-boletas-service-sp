package com.certicom.certifact_boletas_service_sp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCuotasRequest {

    private Long idCuotas;
    private Integer numero;
    private BigDecimal monto;
    private String fecha;
    private Long idPaymentVoucher;

}
