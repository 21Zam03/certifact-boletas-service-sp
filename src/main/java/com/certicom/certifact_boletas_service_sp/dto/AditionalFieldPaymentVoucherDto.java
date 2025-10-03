package com.certicom.certifact_boletas_service_sp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AditionalFieldPaymentVoucherDto {

    private Long id;
    private String nombreCampo;
    private String valorCampo;
    private Long typeFieldId;
    private Long idPaymentVoucher;

}
