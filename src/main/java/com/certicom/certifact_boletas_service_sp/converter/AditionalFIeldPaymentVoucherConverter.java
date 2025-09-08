package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.AditionalFieldPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.request.AditionalFieldPaymentVoucherRequest;

public class AditionalFIeldPaymentVoucherConverter {

    public static AditionalFieldPaymentVoucherModel requestToModel(AditionalFieldPaymentVoucherRequest aditionalFieldPaymentVoucherRequest) {
        return AditionalFieldPaymentVoucherModel.builder().build();
    }

}
