package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.DetailDocsSummaryConverter;
import com.certicom.certifact_boletas_service_sp.converter.SummaryDocumentsConverter;
import com.certicom.certifact_boletas_service_sp.converter.SummaryFileConverter;
import com.certicom.certifact_boletas_service_sp.dto.SummaryDetailDto;
import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.dto.others.RucEstadoOther;
import com.certicom.certifact_boletas_service_sp.mapper.DetailDocsSummaryMapper;
import com.certicom.certifact_boletas_service_sp.mapper.SummaryDocumentsMapper;
import com.certicom.certifact_boletas_service_sp.mapper.SummaryFileMapper;
import com.certicom.certifact_boletas_service_sp.model.DetailDocsSummaryModel;
import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;
import com.certicom.certifact_boletas_service_sp.model.SummaryFileModel;
import com.certicom.certifact_boletas_service_sp.service.SummaryDocumentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SummaryDocumentsServiceImpl implements SummaryDocumentsService {

    private final SummaryDocumentsMapper summaryDocumentsMapper;
    private final DetailDocsSummaryMapper detailDocsSummaryMapper;
    private final SummaryFileMapper summaryFileMapper;

    @Override
    public Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision) {
        Integer correlativo = null;
        try {
            correlativo = summaryDocumentsMapper.getCorrelativoInSummary(rucEmisor, fechaEmision);
        } catch (Exception e) {
            watchLogs(e);
        }
        return correlativo;
    }

    @Override
    @Transactional
    public SummaryDto save(SummaryDto summary) {
        SummaryDto summaryDto = null;
        int result = 0;
        try {
            SummaryDocumentsModel summaryDocumentsModel = SummaryDocumentsConverter.dtoToModel(summary);
            result = summaryDocumentsMapper.save(summaryDocumentsModel);
            if(result == 0) {
                throw new RuntimeException("No se pudo registrar el comprobante");
            }
            if (summary.getItems() != null && !summary.getItems().isEmpty()) {
                List<DetailDocsSummaryModel> list = DetailDocsSummaryConverter.dtoListToModelList(summary.getItems());
                for (DetailDocsSummaryModel detailDocsSummaryModel : list) {
                    detailDocsSummaryModel.setIdDocsSummary(summaryDocumentsModel.getIdDocumentSummary());
                    result = detailDocsSummaryMapper.save(detailDocsSummaryModel);
                    if(result == 0) {
                        throw new RuntimeException("No se pudo registrar el detail summary");
                    }
                }
            }
            if(summary.getSummaryFileDtoList() != null && !summary.getSummaryFileDtoList().isEmpty()) {
                List<SummaryFileModel> list = SummaryFileConverter.dtoListToModelList(summary.getSummaryFileDtoList());
                for (SummaryFileModel summaryFileModel : list) {
                    result = summaryFileMapper.save(summaryFileModel);
                    if (result == 0) {
                        throw new RuntimeException("No se pudo registrar el summary file");
                    }
                }
            }
            SummaryDocumentsModel summaryCreated = summaryDocumentsMapper.findById(summaryDocumentsModel.getIdDocumentSummary());
            summaryDto = SummaryDocumentsConverter.modelToDto(summaryCreated);
        } catch (Exception e) {
            watchLogs(e);
        }
        return summaryDto;
    }

    @Override
    public String getEstadoByNumeroTicket(String ticket) {
        return summaryDocumentsMapper.getEstadoByNumeroTicket(ticket);
    }

    @Override
    public List<RucEstadoOther> getEstadoAndRucEmisorByNumeroTicket(String ticket) {
        return summaryDocumentsMapper.getEstadoAndRucEmisorByNumeroTicket(ticket);
    }

    @Override
    public SummaryDto findByTicket(String ticket) {
        SummaryDto summaryDto = null;
        try {
            SummaryDocumentsModel summary = summaryDocumentsMapper.findByTicket(ticket);
            summaryDto = SummaryDocumentsConverter.modelToDto(summary);

            List<DetailDocsSummaryModel> detailDocsSummaryModelList = detailDocsSummaryMapper.findByIdDocsSummary(summary.getIdDocumentSummary());
            System.out.println("ITEMS: "+detailDocsSummaryModelList);
            summaryDto.setItems(DetailDocsSummaryConverter.modelListToDtoList(detailDocsSummaryModelList));
        } catch (Exception e) {
            watchLogs(e);
        }
        return summaryDto;
    }

    private void watchLogs(Exception e) {
        log.error("ERROR: {}", e.getMessage());
    }

}
