package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.DetailDocsSummaryModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailDocsSummaryMapper {

    int save(DetailDocsSummaryModel detailDocsSummaryModel);

}
