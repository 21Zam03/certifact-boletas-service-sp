package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherFileRequest;

public class PaymentVoucherFileConverter {

    public static PaymentVoucherFileModel requetsToModel(PaymentVoucherFileRequest paymentVoucherFileRequest) {
        return PaymentVoucherFileModel.builder().build();
    }

}
