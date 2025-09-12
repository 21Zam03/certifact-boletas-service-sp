package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.BranchOfficeModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchOfficeMapper {

    public BranchOfficeModel findByCompanyIdAndSerieAndTipoComprobante(
            Integer codCompany, String serie, String tipoComprobante);

}
