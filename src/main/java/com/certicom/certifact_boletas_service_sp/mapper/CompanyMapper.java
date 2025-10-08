package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.CompanyModel;
import com.certicom.certifact_boletas_service_sp.model.OseModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper extends BaseMapper<CompanyModel, Long> {

    public String getEstadoByRuc(String rucEmisor);
    public CompanyModel findCompanyByRuc(String ruc);
    public OseModel findOseByRuc(String ruc);

}
