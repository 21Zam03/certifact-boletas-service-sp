package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.PaymentCuotasDto;

import java.util.List;

public interface PaymentCuotasService {

    void updateAllPaymentCuotas(List<PaymentCuotasDto> paymentCuotasDtoList);
    int deletePaymentCuotasById(Long id);

}
