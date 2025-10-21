package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentCuotasModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentCuotasDto;

import java.util.ArrayList;
import java.util.List;

public class PaymentCuotasConverter {

    public static PaymentCuotasModel dtoToModel(PaymentCuotasDto paymentCuotasDto) {
        if(paymentCuotasDto != null) {
            return PaymentCuotasModel.builder()
                    .idCuotas(paymentCuotasDto.getIdCuotas())
                    .numero(paymentCuotasDto.getNumero())
                    .monto(paymentCuotasDto.getMonto())
                    .fecha(paymentCuotasDto.getFecha())
                    .idPaymentVoucher(paymentCuotasDto.getIdPaymentVoucher())
                    .build();
        } else return null;
    }

    public static PaymentCuotasDto modelToDto(PaymentCuotasModel paymentCuotasModel) {
        if(paymentCuotasModel != null) {
            return PaymentCuotasDto.builder()
                    .idCuotas(paymentCuotasModel.getIdCuotas())
                    .numero(paymentCuotasModel.getNumero())
                    .monto(paymentCuotasModel.getMonto())
                    .fecha(paymentCuotasModel.getFecha())
                    .idPaymentVoucher(paymentCuotasModel.getIdPaymentVoucher())
                    .build();
        } else return null;
    }


    public static List<PaymentCuotasModel> dtoListToModelList(List<PaymentCuotasDto> paymentCuotasDtoList) {
        if(paymentCuotasDtoList != null && !paymentCuotasDtoList.isEmpty()) {
            List<PaymentCuotasModel> paymentCuotasModelList = new ArrayList<>();
            for (PaymentCuotasDto paymentCuotasDto : paymentCuotasDtoList) {
                paymentCuotasModelList.add(dtoToModel(paymentCuotasDto));
            }
            return paymentCuotasModelList;
        } else return null;
    }

    public static List<PaymentCuotasDto> modelListToDtoList(List<PaymentCuotasModel> paymentCuotasModelList) {
        if (paymentCuotasModelList != null && !paymentCuotasModelList.isEmpty()) {
            List<PaymentCuotasDto> paymentCuotasDtoList = new ArrayList<>();
            for (PaymentCuotasModel paymentCuotasModel : paymentCuotasModelList) {
                paymentCuotasDtoList.add(modelToDto(paymentCuotasModel));
            }
            return paymentCuotasDtoList;
        } else return null;
    }

}
