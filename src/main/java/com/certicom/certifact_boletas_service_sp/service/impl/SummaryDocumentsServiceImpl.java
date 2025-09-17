package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.SummaryDocumentsConverter;
import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.mapper.SummaryDocumentsMapper;
import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;
import com.certicom.certifact_boletas_service_sp.service.SummaryDocumentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
@Slf4j
public class SummaryDocumentsServiceImpl implements SummaryDocumentsService {

    private final SummaryDocumentsMapper summaryDocumentsMapper;

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
        } catch (Exception e) {
            watchLogs(e);
        }
        return summaryDto;
    }

    private void watchLogs(Exception e) {
        log.error("ERROR: {}", e.getMessage());
    }

}
