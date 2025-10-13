package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherFileDto;

import java.util.List;

public interface PaymentVoucherFileService  {

    PaymentVoucherFileDto savePaymentVoucherFile(PaymentVoucherFileDto paymentVoucherFileDto);
    int updatePaymentVoucherFile(PaymentVoucherFileDto paymentVoucherFileDto);
    int saveAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos);
    void updateAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos);

    //Metodos de consultas personalizadas

}
