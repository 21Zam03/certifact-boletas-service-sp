package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.AditionalFieldPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.AditionalFieldPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class AditionalFIeldPaymentVoucherConverter {

    public static AditionalFieldPaymentVoucherModel dtoToModel(AditionalFieldPaymentVoucherDto aditionalFieldPaymentVoucherDto) {
        if(aditionalFieldPaymentVoucherDto != null) {
            return AditionalFieldPaymentVoucherModel.builder()
                    .id(aditionalFieldPaymentVoucherDto.getId())
                    .nombreCampo(aditionalFieldPaymentVoucherDto.getNombreCampo())
                    .valorCampo(aditionalFieldPaymentVoucherDto.getValorCampo())
                    .typeFieldId(aditionalFieldPaymentVoucherDto.getTypeFieldId())
                    .idPaymentVoucher(aditionalFieldPaymentVoucherDto.getIdPaymentVoucher())
                    .build();
        } else return null;
    }

    public static AditionalFieldPaymentVoucherDto modelToDto(AditionalFieldPaymentVoucherModel aditionalFieldPaymentVoucherModel) {
        if(aditionalFieldPaymentVoucherModel != null) {
            return AditionalFieldPaymentVoucherDto.builder()
                    .id(aditionalFieldPaymentVoucherModel.getId())
                    .nombreCampo(aditionalFieldPaymentVoucherModel.getNombreCampo())
                    .valorCampo(aditionalFieldPaymentVoucherModel.getValorCampo())
                    .typeFieldId(aditionalFieldPaymentVoucherModel.getTypeFieldId())
                    .idPaymentVoucher(aditionalFieldPaymentVoucherModel.getIdPaymentVoucher())
                    .build();
        } else return null;
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

    public static List<AditionalFieldPaymentVoucherDto> modelListToDtoList(List<AditionalFieldPaymentVoucherModel> aditionalFieldPaymentVoucherModels) {
        if (aditionalFieldPaymentVoucherModels != null && !aditionalFieldPaymentVoucherModels.isEmpty()) {
            List<AditionalFieldPaymentVoucherDto> aditionalFieldPaymentVoucherDtos = new ArrayList<>();
            for (AditionalFieldPaymentVoucherModel aditionalFieldPaymentVoucherModel : aditionalFieldPaymentVoucherModels) {
                aditionalFieldPaymentVoucherDtos.add(modelToDto(aditionalFieldPaymentVoucherModel));
            }
            return aditionalFieldPaymentVoucherDtos;
        } else return null;
    }

}
