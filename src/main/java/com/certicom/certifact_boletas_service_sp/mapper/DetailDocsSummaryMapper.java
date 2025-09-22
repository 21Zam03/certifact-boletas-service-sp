package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.DetailDocsSummaryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailDocsSummaryMapper {

    int save(DetailDocsSummaryModel detailDocsSummaryModel);
    List<DetailDocsSummaryModel> findByIdDocsSummary(Long id);
    Long getIdDocumentSummaryByIdPaymentVoucher(Long id);

}
