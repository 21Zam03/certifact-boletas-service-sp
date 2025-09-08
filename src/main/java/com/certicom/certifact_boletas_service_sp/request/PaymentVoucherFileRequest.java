package com.certicom.certifact_boletas_service_sp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentVoucherFileRequest {

    private Long id;
    private String tipoArchivo;
    private String estadoArchivo;
    private Long idPaymentVoucher;
    private Long idRegisterFileSend;
    private Integer orden;

}
