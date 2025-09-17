package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;

public class SummaryDocumentsConverter {

    public static SummaryDto modelToDto(SummaryDocumentsModel summaryDocumentsModel) {
        if (summaryDocumentsModel != null) {
            return SummaryDto.builder()
                    .fechaEmision(summaryDocumentsModel.getFechaEmision())
                    .nroResumenDelDia(summaryDocumentsModel.getCorrelativoDia())
                    .rucEmisor(summaryDocumentsModel.getRucEmisor())
                    .denominacionEmisor(null)
                    .nombreComercialEmisor(null)
                    .tipoDocumentoEmisor(null)
                    .estadoComprobante(summaryDocumentsModel.getEstadoDocumento())
                    .idDocument(summaryDocumentsModel.getIdDocument())
                    .estado(summaryDocumentsModel.getEstado())
                    .fechaGeneracion(summaryDocumentsModel.getFechaGeneracion())
                    .fechaGereracionResumen(summaryDocumentsModel.getFechaGeneracionResumen())
                    .ticketSunat(summaryDocumentsModel.getTicketSunat())
                    .userName(summaryDocumentsModel.getUserName())
                    .build();
        } else return null;
    }

    public static SummaryDocumentsModel dtoToModel(SummaryDto summaryDto) {
        if (summaryDto != null) {
            return SummaryDocumentsModel.builder()
                    .correlativoDia(summaryDto.getNroResumenDelDia())
                    .descripcionResponse(null)
                    .estado(summaryDto.getEstado())
                    .estadoDocumento(summaryDto.getEstadoComprobante())
                    .fechaEmision(summaryDto.getFechaEmision())
                    .fechaGeneracion(summaryDto.getFechaGeneracion())
                    //.fechaGeneracionResumen(summaryDto)
                    .build();
        } else return null;
    }

}
