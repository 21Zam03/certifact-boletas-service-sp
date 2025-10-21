package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.AnticipoPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class AnticipoPaymentVoucherConverter {

    public static AnticipoPaymentVoucherModel dtoToModel(AnticipoPaymentVoucherDto anticipoPaymentVoucherDto) {
        if(anticipoPaymentVoucherDto != null) {
            return AnticipoPaymentVoucherModel.builder()
                    .idAnticipoPayment(anticipoPaymentVoucherDto.getIdAnticipoPayment())
                    .idPaymentVoucher(anticipoPaymentVoucherDto.getIdPaymentVoucher())
                    .identificadorPago(anticipoPaymentVoucherDto.getIdentificadorPago())
                    .serieAnticipo(anticipoPaymentVoucherDto.getSerieAnticipo())
                    .numeroAnticipo(anticipoPaymentVoucherDto.getNumeroAnticipo())
                    .tipoDocAnticipo(anticipoPaymentVoucherDto.getTipoDocAnticipo())
                    .montoAnticipo(anticipoPaymentVoucherDto.getMontoAnticipo())
                    .build();
        } else return null;
    }

    public static AnticipoPaymentVoucherDto modelToDto(AnticipoPaymentVoucherModel anticipoPaymentVoucherModel) {
        if(anticipoPaymentVoucherModel != null) {
            return AnticipoPaymentVoucherDto.builder()
                    .idAnticipoPayment(anticipoPaymentVoucherModel.getIdAnticipoPayment())
                    .idPaymentVoucher(anticipoPaymentVoucherModel.getIdPaymentVoucher())
                    .identificadorPago(anticipoPaymentVoucherModel.getIdentificadorPago())
                    .serieAnticipo(anticipoPaymentVoucherModel.getSerieAnticipo())
                    .numeroAnticipo(anticipoPaymentVoucherModel.getNumeroAnticipo())
                    .tipoDocAnticipo(anticipoPaymentVoucherModel.getTipoDocAnticipo())
                    .montoAnticipo(anticipoPaymentVoucherModel.getMontoAnticipo())
                    .build();
        } else return null;
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

    public static List<AnticipoPaymentVoucherDto> modelListToDtoList(List<AnticipoPaymentVoucherModel> anticipoPaymentVoucherModels) {
        if (anticipoPaymentVoucherModels != null && !anticipoPaymentVoucherModels.isEmpty()) {
            List<AnticipoPaymentVoucherDto> anticipoPaymentVoucherDtos = new ArrayList<>();
            for (AnticipoPaymentVoucherModel anticipoPaymentVoucherModel : anticipoPaymentVoucherModels) {
                anticipoPaymentVoucherDtos.add(modelToDto(anticipoPaymentVoucherModel));
            }
            return anticipoPaymentVoucherDtos;
        } else return null;
    }

}
