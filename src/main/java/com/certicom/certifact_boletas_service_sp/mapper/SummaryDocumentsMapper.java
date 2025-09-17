package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.SummaryDocumentsModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SummaryDocumentsMapper {

    Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision);
    int save(SummaryDocumentsModel summaryDocumentsModel);

}
