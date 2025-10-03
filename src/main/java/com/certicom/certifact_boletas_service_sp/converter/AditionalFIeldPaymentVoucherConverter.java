package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.AditionalFieldPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.AditionalFieldPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class AditionalFIeldPaymentVoucherConverter {

    public static AditionalFieldPaymentVoucherModel dtoToModel(AditionalFieldPaymentVoucherDto aditionalFieldPaymentVoucherDto) {
        return AditionalFieldPaymentVoucherModel.builder()
                .id(aditionalFieldPaymentVoucherDto.getId())
                .nombreCampo(aditionalFieldPaymentVoucherDto.getNombreCampo())
                .valorCampo(aditionalFieldPaymentVoucherDto.getValorCampo())
                .typeFieldId(aditionalFieldPaymentVoucherDto.getTypeFieldId())
                .idPaymentVoucher(aditionalFieldPaymentVoucherDto.getIdPaymentVoucher())
                .build();
    }

    public static List<AditionalFieldPaymentVoucherModel> dtoListToModelList(List<AditionalFieldPaymentVoucherDto> aditionalFieldPaymentVoucherDtos) {
        if(aditionalFieldPaymentVoucherDtos != null && !aditionalFieldPaymentVoucherDtos.isEmpty()) {
            List<AditionalFieldPaymentVoucherModel> aditionalFieldPaymentVoucherModels = new ArrayList<>();
            for (AditionalFieldPaymentVoucherDto aditionalFieldPaymentVoucherDto : aditionalFieldPaymentVoucherDtos) {
                aditionalFieldPaymentVoucherModels.add(dtoToModel(aditionalFieldPaymentVoucherDto));
            }
            return aditionalFieldPaymentVoucherModels;
        } else return null;
    }

}
