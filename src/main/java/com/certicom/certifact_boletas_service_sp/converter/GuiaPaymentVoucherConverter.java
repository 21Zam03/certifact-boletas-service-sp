package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.GuiaPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.GuiaPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class GuiaPaymentVoucherConverter {

    public static GuiaPaymentVoucherModel dtoToModel (GuiaPaymentVoucherDto guiaPaymentVoucherDto) {
        if(guiaPaymentVoucherDto != null) {
            return GuiaPaymentVoucherModel.builder()
                    .idguiaremision(guiaPaymentVoucherDto.getIdguiaremision())
                    .codigoTipoGuia(guiaPaymentVoucherDto.getCodigoTipoGuia())
                    .serieNumeroGuia(guiaPaymentVoucherDto.getSerieNumeroGuia())
                    .idPaymentVoucher(guiaPaymentVoucherDto.getIdPaymentVoucher())
                    .build();
        } else return null;
    }

    public static GuiaPaymentVoucherDto modelToDto(GuiaPaymentVoucherModel guiaPaymentVoucherModel) {
        if(guiaPaymentVoucherModel != null) {
            return GuiaPaymentVoucherDto.builder()
                    .idguiaremision(guiaPaymentVoucherModel.getIdguiaremision())
                    .codigoTipoGuia(guiaPaymentVoucherModel.getCodigoTipoGuia())
                    .serieNumeroGuia(guiaPaymentVoucherModel.getSerieNumeroGuia())
                    .idPaymentVoucher(guiaPaymentVoucherModel.getIdPaymentVoucher())
                    .build();
        } else return null;
    }


    public static List<GuiaPaymentVoucherModel> dtoListToModelList(List<GuiaPaymentVoucherDto> guiaPaymentVoucherDtoList) {
        if(guiaPaymentVoucherDtoList != null && !guiaPaymentVoucherDtoList.isEmpty()) {
            List<GuiaPaymentVoucherModel> guiaPaymentVoucherModelList = new ArrayList<>();
            for (GuiaPaymentVoucherDto guiaPayment :  guiaPaymentVoucherDtoList) {
                guiaPaymentVoucherModelList.add(dtoToModel(guiaPayment));
            }
            return guiaPaymentVoucherModelList;
        } else return null;
    }

    public static List<GuiaPaymentVoucherDto> modelListToDtoList(List<GuiaPaymentVoucherModel> guiaPaymentVoucherModelList) {
        if (guiaPaymentVoucherModelList != null && !guiaPaymentVoucherModelList.isEmpty()) {
            List<GuiaPaymentVoucherDto> guiaPaymentVoucherDtoList = new ArrayList<>();
            for (GuiaPaymentVoucherModel guiaPayment : guiaPaymentVoucherModelList) {
                guiaPaymentVoucherDtoList.add(modelToDto(guiaPayment));
            }
            return guiaPaymentVoucherDtoList;
        } else return null;
    }

}
