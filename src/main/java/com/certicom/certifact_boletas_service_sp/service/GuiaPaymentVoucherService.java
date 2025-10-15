package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.GuiaPaymentVoucherDto;

import java.util.List;

public interface GuiaPaymentVoucherService {

    void updateGuiaPaymentVoucher(List<GuiaPaymentVoucherDto> guiaPaymentVoucherDtoList);
    int deleteGuiaPaymentVoucherById(Long id);

}
