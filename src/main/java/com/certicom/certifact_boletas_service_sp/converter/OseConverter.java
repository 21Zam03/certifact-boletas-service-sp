package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.OseDto;
import com.certicom.certifact_boletas_service_sp.model.OseModel;

public class OseConverter {

    public static OseDto modelToDto(OseModel oseModel) {
        return OseDto.builder()
                .id(oseModel.getOsesId())
                .urlFacturas(oseModel.getUrlFacturas())
                .urlGuias(oseModel.getUrlGuias())
                .build();
    }

}
