package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;

public interface SummaryDocumentsService {

    Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision);
    SummaryDto save(SummaryDto summaryDto);

}
