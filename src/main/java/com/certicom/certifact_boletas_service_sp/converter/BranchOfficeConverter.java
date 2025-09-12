package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.BranchOfficeDto;
import com.certicom.certifact_boletas_service_sp.model.BranchOfficeModel;

public class BranchOfficeConverter {

    public static BranchOfficeDto modelToDto(BranchOfficeModel branchOfficeModel) {
        if(branchOfficeModel != null) {
            return BranchOfficeDto.builder()
                    .id(branchOfficeModel.getId())
                    .build();
        } else return null;
    }

}
