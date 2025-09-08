package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.request.PaymentVoucherRequest;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;

public interface PaymentVoucherService {

    PaymentVoucherResponse save(PaymentVoucherRequest paymentVoucherRequest);

}
