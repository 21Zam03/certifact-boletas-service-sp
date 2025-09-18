package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.dto.others.RucEstadoOther;

import java.util.List;

public interface SummaryDocumentsService {

    Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision);
    SummaryDto save(SummaryDto summaryDto);
    String getEstadoByNumeroTicket(String ticket);
    List<RucEstadoOther> getEstadoAndRucEmisorByNumeroTicket(String ticket);
    SummaryDto findByTicket(String ticket);

}
