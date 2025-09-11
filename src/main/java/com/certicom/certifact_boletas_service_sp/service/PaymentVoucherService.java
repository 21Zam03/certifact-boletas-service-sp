package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;

public interface PaymentVoucherService {

    PaymentVoucherResponse save(PaymentVoucherDto paymentVoucherDto);
    PaymentVoucherDto update(PaymentVoucherDto paymentVoucherDto);
    int delete(Long id);
    PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento);
    Integer getNumeracion(String tipoComprobante, String serie, String ruc);

}
