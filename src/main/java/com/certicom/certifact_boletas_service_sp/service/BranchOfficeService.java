package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.BranchOfficeDto;

public interface BranchOfficeService {

    public BranchOfficeDto findByCompanyIdAndSerieAndTipoComprobante(Integer empresaId, String serie, String tipoComprobante);

}
