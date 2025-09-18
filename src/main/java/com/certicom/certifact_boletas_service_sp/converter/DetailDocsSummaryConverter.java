package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDetailDto;
import com.certicom.certifact_boletas_service_sp.model.DetailDocsSummaryModel;
import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;

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

    public static SummaryDetailDto modelToDto(DetailDocsSummaryModel detailDocsSummaryModel) {
        if(detailDocsSummaryModel != null) {
            return SummaryDetailDto.builder()
                    .numeroItem(detailDocsSummaryModel.getNumeroItem())
                    .serie(detailDocsSummaryModel.getSerieDocumento())
                    .numero(detailDocsSummaryModel.getNumeroDocumento())
                    .tipoComprobante(detailDocsSummaryModel.getTipoComprobante())
                    .tipoDocumentoReceptor(detailDocsSummaryModel.getTipDocIdentReceptor())
                    .numeroDocumentoReceptor(detailDocsSummaryModel.getNumDocReceptor())
                    .serieAfectado(detailDocsSummaryModel.getSerieAfectado())
                    .numeroAfectado(detailDocsSummaryModel.getNumeroAfectado())
                    .tipoComprobanteAfectado(detailDocsSummaryModel.getTipComprobAfectado())
                    .statusItem(detailDocsSummaryModel.getEstadoItem())
                    .importeTotalVenta(detailDocsSummaryModel.getImporteTotalVenta())
                    .sumatoriaOtrosCargos(detailDocsSummaryModel.getSumatoriaOtroCargos())
                    .totalValorVentaOperacionExonerado(detailDocsSummaryModel.getTotalOperExonerado())
                    .totalValorVentaOperacionExportacion(detailDocsSummaryModel.getTotalOperExportacion())
                    .totalValorVentaOperacionGratuita(detailDocsSummaryModel.getTotalOperGratuita())
                    .totalValorVentaOperacionGravada(detailDocsSummaryModel.getTotalOperGravada())
                    .totalValorVentaOperacionInafecta(detailDocsSummaryModel.getTotalOperInafecta())
                    .totalIGV(detailDocsSummaryModel.getTotalIgv())
                    .totalISC(detailDocsSummaryModel.getTotalIsc())
                    .totalOtrosTributos(detailDocsSummaryModel.getTotalOtrosTrib())
                    .estado(detailDocsSummaryModel.getEstado())
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

    public static List<SummaryDetailDto> modelListToDtoList(List<DetailDocsSummaryModel> detailDocsSummaryModelList) {
        if(detailDocsSummaryModelList != null && !detailDocsSummaryModelList.isEmpty()) {
        List<SummaryDetailDto> summaryDetailDtoList = new ArrayList<>();
            for (DetailDocsSummaryModel detailDocsSummaryModel : detailDocsSummaryModelList) {
                summaryDetailDtoList.add(modelToDto(detailDocsSummaryModel));
            }
            return summaryDetailDtoList;
        } else return null;
    }

}
