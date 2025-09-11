package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.CompanyDto;
import com.certicom.certifact_boletas_service_sp.dto.OseDto;

public interface CompanyService {

    public String getEstadoByRuc(String rucEmisor);
    public CompanyDto findByRuc(String ruc);
    public OseDto findOseByRuc(String ruc);

}
