package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.mapper.SummaryDocumentsMapper;
import com.certicom.certifact_boletas_service_sp.service.SummaryDocumentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.datatransfer.FlavorEvent;

@Service
@RequiredArgsConstructor
@Slf4j
public class SummaryDocumentsServiceImpl implements SummaryDocumentsService {

    private final SummaryDocumentsMapper summaryDocumentsMapper;

    @Override
    public Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision) {
        System.out.println("RUC EMISOR: "+ rucEmisor);
        System.out.println("FECHA EMISION: "+ fechaEmision);
        Integer correlativo = null;
        try {
            correlativo = summaryDocumentsMapper.getCorrelativoInSummary(rucEmisor, fechaEmision);
        } catch (Exception e) {
            watchLogs(e);
        }
        return correlativo;
    }

    private void watchLogs(Exception e) {
        log.error("ERROR: {}", e.getMessage());
    }

}
