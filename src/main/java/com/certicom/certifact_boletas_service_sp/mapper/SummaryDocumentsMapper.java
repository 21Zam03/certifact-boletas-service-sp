package com.certicom.certifact_boletas_service_sp.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SummaryDocumentsMapper {

    Integer getCorrelativoInSummary(String rucEmisor, String fechaEmision);

}
