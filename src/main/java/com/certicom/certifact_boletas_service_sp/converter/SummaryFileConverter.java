package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.SummaryFileDto;
import com.certicom.certifact_boletas_service_sp.model.SummaryFileModel;

import java.util.ArrayList;
import java.util.List;

public class SummaryFileConverter {

    public static SummaryFileModel dtoToModel(SummaryFileDto summaryFileDto) {
        if(summaryFileDto != null) {
            return SummaryFileModel.builder()
                    .id(summaryFileDto.getId())
                    .estadoArchivo(summaryFileDto.getEstadoArchivo())
                    .orden(summaryFileDto.getOrden())
                    .tipoArchivo(summaryFileDto.getTipoArchivo())
                    .idRegisterFileSend(summaryFileDto.getIdRegisterFileSend())
                    .idDocumentSummary(summaryFileDto.getIdDocumentSummary())
                    .build();
        } else return null;
    }

    public static List<SummaryFileModel> dtoListToModelList(List<SummaryFileDto> summaryFileDtoList) {
        if (summaryFileDtoList != null && !summaryFileDtoList.isEmpty()) {
            List<SummaryFileModel> summaryFileModelList = new ArrayList<>();
            for (SummaryFileDto summaryFileDto : summaryFileDtoList) {
                summaryFileModelList.add(dtoToModel(summaryFileDto));
            }
            return summaryFileModelList;
        } else return null;
    }

}
