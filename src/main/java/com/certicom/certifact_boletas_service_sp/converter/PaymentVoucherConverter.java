package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.request.PaymentVoucherRequest;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;

public class PaymentVoucherConverter {

    public static PaymentVoucherModel requestToModel(PaymentVoucherRequest paymentVoucherRequest) {
        return PaymentVoucherModel.builder()
                .build();
    }

    public static PaymentVoucherResponse ModelToResponse(PaymentVoucherModel paymentVoucherModel) {
        return PaymentVoucherResponse.builder().build();
    }

}
