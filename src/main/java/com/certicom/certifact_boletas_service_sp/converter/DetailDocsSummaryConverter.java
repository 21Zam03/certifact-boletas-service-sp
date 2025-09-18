package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDetailDto;
import com.certicom.certifact_boletas_service_sp.model.DetailDocsSummaryModel;

import java.util.ArrayList;
import java.util.List;

public class DetailDocsSummaryConverter {

    public static DetailDocsSummaryModel dtoToModel(SummaryDetailDto summaryDetailDto) {
        if(summaryDetailDto != null) {
            return DetailDocsSummaryModel.builder()
                    .numeroItem(summaryDetailDto.getNumeroItem())
                    .serieDocumento(summaryDetailDto.getSerie())
                    .numeroDocumento(summaryDetailDto.getNumero())
                    .tipoComprobante(summaryDetailDto.getTipoComprobante())
                    .tipDocIdentReceptor(summaryDetailDto.getTipoDocumentoReceptor())
                    .numDocReceptor(summaryDetailDto.getNumeroDocumentoReceptor())
                    .serieAfectado(summaryDetailDto.getSerieAfectado())
                    .numeroAfectado(summaryDetailDto.getNumeroAfectado())
                    .tipComprobAfectado(summaryDetailDto.getTipoComprobanteAfectado())
                    .estadoItem(summaryDetailDto.getStatusItem())
                    .importeTotalVenta(summaryDetailDto.getImporteTotalVenta())
                    .sumatoriaOtroCargos(summaryDetailDto.getSumatoriaOtrosCargos())
                    .totalOperExonerado(summaryDetailDto.getTotalValorVentaOperacionExonerado())
                    .totalOperExportacion(summaryDetailDto.getTotalValorVentaOperacionExportacion())
                    .totalOperGratuita(summaryDetailDto.getTotalValorVentaOperacionGratuita())
                    .totalOperGravada(summaryDetailDto.getTotalValorVentaOperacionGravada())
                    .totalOperInafecta(summaryDetailDto.getTotalValorVentaOperacionInafecta())
                    .totalIgv(summaryDetailDto.getTotalIGV())
                    .totalIsc(summaryDetailDto.getTotalISC())
                    .totalOtrosTrib(summaryDetailDto.getTotalOtrosTributos())
                    .estado(summaryDetailDto.getEstado())
                    .build();
        } else return null;
    }

    public static List<DetailDocsSummaryModel> dtoListToModelList(List<SummaryDetailDto> summaryDetailDtoList) {
        if(summaryDetailDtoList != null && !summaryDetailDtoList.isEmpty()) {
            List<DetailDocsSummaryModel> detailDocsSummaryModelList = new ArrayList<>();
            for (SummaryDetailDto summaryDetailDto : summaryDetailDtoList) {
                detailDocsSummaryModelList.add(dtoToModel(summaryDetailDto));
            }
            return detailDocsSummaryModelList;
        } else return null;
    }

}
