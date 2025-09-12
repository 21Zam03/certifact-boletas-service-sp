package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.BranchOfficeConverter;
import com.certicom.certifact_boletas_service_sp.dto.BranchOfficeDto;
import com.certicom.certifact_boletas_service_sp.mapper.BranchOfficeMapper;
import com.certicom.certifact_boletas_service_sp.model.BranchOfficeModel;
import com.certicom.certifact_boletas_service_sp.service.BranchOfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchOfficeServiceImpl implements BranchOfficeService {

    private final BranchOfficeMapper branchOfficeMapper;

    @Override
    public BranchOfficeDto findByCompanyIdAndSerieAndTipoComprobante(Integer empresaId, String serie, String tipoComprobante) {
        BranchOfficeDto branchOfficeDto = null;
        try {
            BranchOfficeModel branchOfficeModel = branchOfficeMapper.findByCompanyIdAndSerieAndTipoComprobante(empresaId, serie, tipoComprobante);
            branchOfficeDto = BranchOfficeConverter.modelToDto(branchOfficeModel);
        } catch (Exception e) {
            watchLogs(e);
        }
        return branchOfficeDto;
    }

    private void watchLogs(Exception e ){
        log.error("ERROR: {}", e.getMessage());
    }

}
