package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.GuiaPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.request.GuiaPaymentVoucherRequest;

public class GuiaPaymentVoucherConverter {

    public static GuiaPaymentVoucherModel requestToModel (GuiaPaymentVoucherRequest guiaPaymentVoucherRequest) {
        return GuiaPaymentVoucherModel.builder().build();
    }

}
