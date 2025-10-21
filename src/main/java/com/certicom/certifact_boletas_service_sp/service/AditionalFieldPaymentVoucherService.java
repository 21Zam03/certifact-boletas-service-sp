package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.AditionalFieldPaymentVoucherDto;

import java.util.List;

public interface AditionalFieldPaymentVoucherService {

    void updateAllAditionalFieldPaymentVoucher(List<AditionalFieldPaymentVoucherDto> aditionalFieldPaymentVoucherDtoList);
    int deleteAditionalFieldPaymentVoucherService(Long id);
    int saveAllAditionalFieldPaymentVoucher(List<AditionalFieldPaymentVoucherDto> camposAdicionales);

}
