package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentCuotasModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentCuotasDto;

import java.util.ArrayList;
import java.util.List;

public class PaymentCuotasConverter {

    public static PaymentCuotasModel dtoToModel(PaymentCuotasDto paymentCuotasDto) {
        return PaymentCuotasModel.builder()
                .idCuotas(paymentCuotasDto.getIdCuotas())
                .numero(paymentCuotasDto.getNumero())
                .monto(paymentCuotasDto.getMonto())
                .fecha(paymentCuotasDto.getFecha())
                .idPaymentVoucher(paymentCuotasDto.getIdPaymentVoucher())
                .build();
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

}
