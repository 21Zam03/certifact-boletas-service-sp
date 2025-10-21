package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.AnticipoPaymentVoucherDto;

import java.util.List;

public interface AnticipoPaymentVoucherService {

    void updateAnticipoPaymentVoucher(AnticipoPaymentVoucherDto anticipoPaymentVoucherDto);
    void updateAllAnticipoPaymentVoucher(List<AnticipoPaymentVoucherDto> anticipoPaymentVoucherDtos);
    int deleteAnticipoPaymentVoucherById(Long id);
    int saveAllAnticipoPaymentVoucher(List<AnticipoPaymentVoucherDto> anticipos);

}
