package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentCuotasModel;
import com.certicom.certifact_boletas_service_sp.request.PaymentCuotasRequest;

public class PaymentCuotasConverter {

    public static PaymentCuotasModel requestToModel(PaymentCuotasRequest paymentCuotasRequest) {
        return PaymentCuotasModel.builder()

                .build();
    }

}
