package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.AnticipoPaymentVoucherRequest;

public class AnticipoPaymentVoucherConverter {

    public static AnticipoPaymentVoucherModel requestToModel(AnticipoPaymentVoucherRequest anticipoPaymentVoucherRequest) {
        return AnticipoPaymentVoucherModel.builder().build();
    }

}
