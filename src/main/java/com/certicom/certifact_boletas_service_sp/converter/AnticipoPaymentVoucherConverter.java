package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.AnticipoPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class AnticipoPaymentVoucherConverter {

    public static AnticipoPaymentVoucherModel dtoToModel(AnticipoPaymentVoucherDto anticipoPaymentVoucherDto) {
        return AnticipoPaymentVoucherModel.builder()
                .idAnticipoPayment(anticipoPaymentVoucherDto.getIdAnticipoPayment())
                .idPaymentVoucher(anticipoPaymentVoucherDto.getIdPaymentVoucher())
                .identificadorPago(anticipoPaymentVoucherDto.getIdentificadorPago())
                .serieAnticipo(anticipoPaymentVoucherDto.getSerieAnticipo())
                .numeroAnticipo(anticipoPaymentVoucherDto.getNumeroAnticipo())
                .tipoDocAnticipo(anticipoPaymentVoucherDto.getTipoDocAnticipo())
                .montoAnticipo(anticipoPaymentVoucherDto.getMontoAnticipo())
                .build();
    }

    public static List<AnticipoPaymentVoucherModel> dtoListToModelList(List<AnticipoPaymentVoucherDto> anticipoPaymentVoucherDtos) {
        if(anticipoPaymentVoucherDtos != null && !anticipoPaymentVoucherDtos.isEmpty()) {
            List<AnticipoPaymentVoucherModel> anticipoPaymentVoucherModels = new ArrayList<>();
            for (AnticipoPaymentVoucherDto anticipoPaymentVoucherDto : anticipoPaymentVoucherDtos) {
                anticipoPaymentVoucherModels.add(dtoToModel(anticipoPaymentVoucherDto));
            }
            return anticipoPaymentVoucherModels;
        } else return null;
    }

}
