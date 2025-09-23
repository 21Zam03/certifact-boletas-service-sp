package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;

public class SummaryDocumentsConverter {

    public static SummaryDto modelToDto(SummaryDocumentsModel summaryDocumentsModel) {
        if (summaryDocumentsModel != null) {
            System.out.println("TICKET SUNAT: "+summaryDocumentsModel.getTicketSunat());
            return SummaryDto.builder()
                    .descripcionResponse(summaryDocumentsModel.getDescriptionResponse())
                    .idDocumentSummary(summaryDocumentsModel.getIdDocumentSummary())
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
                    .idDocumentSummary(summaryDto.getIdDocumentSummary())
                    .fechaEmision(summaryDto.getFechaEmision())
                    .correlativoDia(summaryDto.getNroResumenDelDia())
                    .rucEmisor(summaryDto.getRucEmisor())
                    .descriptionResponse(summaryDto.getDescripcionResponse())
                    .codeResponse(summaryDto.getCodeResponse())
                    .estado(summaryDto.getEstado())
                    .estadoDocumento(summaryDto.getEstadoComprobante())
                    .fechaGeneracion(summaryDto.getFechaGeneracion())
                    .fechaGeneracionResumen(summaryDto.getFechaGereracionResumen())
                    .ticketSunat(summaryDto.getTicketSunat())
                    .userNameModify(summaryDto.getUserNameModify())
                    .userName(summaryDto.getUserName())
                    .fechaModificacion(summaryDto.getFechaModificacion())
                    .idDocument(summaryDto.getIdDocument())
                    .build();
        } else return null;
    }

}
