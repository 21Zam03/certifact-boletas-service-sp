package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.DetailsPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.DetailsPaymentVoucherRequest;

public class DetailsPaymentVoucherConverter {

    public static DetailsPaymentVoucherModel requestToModel(DetailsPaymentVoucherRequest detailsPaymentVoucherRequest) {
        return DetailsPaymentVoucherModel.builder().build();
    }

}
