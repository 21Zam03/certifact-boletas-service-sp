package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherFileDto;

public class PaymentVoucherFileConverter {

    public static PaymentVoucherFileModel dtoToModel(PaymentVoucherFileDto paymentVoucherFileDto) {
        return PaymentVoucherFileModel.builder()
                .tipoArchivo(paymentVoucherFileDto.getTipoArchivo())
                .estadoArchivo(paymentVoucherFileDto.getEstadoArchivo())
                .idPaymentVoucher(paymentVoucherFileDto.getIdPaymentVoucher())
                .idRegisterFileSend(paymentVoucherFileDto.getIdRegisterFileSend())
                .orden(paymentVoucherFileDto.getOrden())
                .build();
    }

}
