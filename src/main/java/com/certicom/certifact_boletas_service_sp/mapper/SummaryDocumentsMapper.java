package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.dto.others.RucEstadoOther;
import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SummaryDocumentsMapper {

    Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision);
    int save(SummaryDocumentsModel summaryDocumentsModel);
    SummaryDocumentsModel findById(Long id);
    List<RucEstadoOther> getEstadoAndRucEmisorByNumeroTicket(String ticket);
    String getEstadoByNumeroTicket(String ticket);
    SummaryDocumentsModel findByTicket(String ticket);

}
