package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.DetailsPaymentVoucherDto;

import java.util.List;

public interface DetailsPaymentVoucherService {

    void updateAllDetailsPaymentVouhcer(List<DetailsPaymentVoucherDto> detailsPaymentVoucherDtoList);
    int deleteDetailPaymentVoucherById(Long id);

}
