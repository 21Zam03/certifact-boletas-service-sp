package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherFileDto;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherFileService;

import java.util.ArrayList;
import java.util.List;

public class PaymentVoucherFileConverter {

    public static PaymentVoucherFileDto modelToDto(PaymentVoucherFileModel paymentVoucherFileModel) {
        if( paymentVoucherFileModel != null) {
            return PaymentVoucherFileDto.builder()
                    .tipoArchivo(paymentVoucherFileModel.getTipoArchivo())
                    .estadoArchivo(paymentVoucherFileModel.getEstadoArchivo())
                    .idPaymentVoucher(paymentVoucherFileModel.getIdPaymentVoucher())
                    .idRegisterFileSend(paymentVoucherFileModel.getIdRegisterFileSend())
                    .orden(paymentVoucherFileModel.getOrden())
                    .build();
        } else return null;
    }

    public static PaymentVoucherFileModel dtoToModel(PaymentVoucherFileDto paymentVoucherFileDto) {
        return PaymentVoucherFileModel.builder()
                .tipoArchivo(paymentVoucherFileDto.getTipoArchivo())
                .estadoArchivo(paymentVoucherFileDto.getEstadoArchivo())
                .idPaymentVoucher(paymentVoucherFileDto.getIdPaymentVoucher())
                .idRegisterFileSend(paymentVoucherFileDto.getIdRegisterFileSend())
                .orden(paymentVoucherFileDto.getOrden())
                .build();
    }

    public static List<PaymentVoucherFileModel> dtoListToModelList(List<PaymentVoucherFileDto> paymentVoucherFileDtos) {
        if(paymentVoucherFileDtos != null) {
            List<PaymentVoucherFileModel> paymentVoucherFileModels = new ArrayList<>();
            for (PaymentVoucherFileDto paymentVoucherFileDto : paymentVoucherFileDtos) {
                paymentVoucherFileModels.add(dtoToModel(paymentVoucherFileDto));
            }
            return paymentVoucherFileModels;
        } else return null;
    }

}
