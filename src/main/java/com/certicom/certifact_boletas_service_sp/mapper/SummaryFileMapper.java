package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.SummaryFileModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SummaryFileMapper {

    int save(SummaryFileModel summaryFileModel);

}
