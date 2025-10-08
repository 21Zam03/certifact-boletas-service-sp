package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.SummaryDto;
import com.certicom.certifact_boletas_service_sp.dto.others.RucEstadoOther;

import java.util.List;

public interface SummaryDocumentsService {

    SummaryDto save(SummaryDto summaryDto);
    SummaryDto update(SummaryDto summaryDto);

    Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision);
    String getEstadoByNumeroTicket(String ticket);
    List<RucEstadoOther> getEstadoAndRucEmisorByNumeroTicket(String ticket);
    SummaryDto findByTicket(String ticket);
    Long getIdDocumentSummaryByIdPaymentVoucher(Long idPaymentVoucher);

}
