package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.GuiaPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.GuiaPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class GuiaPaymentVoucherConverter {

    public static GuiaPaymentVoucherModel dtoToModel (GuiaPaymentVoucherDto guiaPaymentVoucherDto) {
        return GuiaPaymentVoucherModel.builder()
                .idguiaremision(guiaPaymentVoucherDto.getIdguiaremision())
                .codigoTipoGuia(guiaPaymentVoucherDto.getCodigoTipoGuia())
                .serieNumeroGuia(guiaPaymentVoucherDto.getSerieNumeroGuia())
                .idPaymentVoucher(guiaPaymentVoucherDto.getIdPaymentVoucher())
                .build();
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

}
