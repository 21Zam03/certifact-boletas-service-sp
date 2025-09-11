package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.CompanyConverter;
import com.certicom.certifact_boletas_service_sp.converter.OseConverter;
import com.certicom.certifact_boletas_service_sp.dto.CompanyDto;
import com.certicom.certifact_boletas_service_sp.dto.OseDto;
import com.certicom.certifact_boletas_service_sp.mapper.CompanyMapper;
import com.certicom.certifact_boletas_service_sp.model.CompanyModel;
import com.certicom.certifact_boletas_service_sp.model.OseModel;
import com.certicom.certifact_boletas_service_sp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    @Override
    public String getEstadoByRuc(String rucEmisor) {
        return companyMapper.getEstadoByRuc(rucEmisor);
    }

    @Override
    public CompanyDto findByRuc(String ruc) {
        CompanyDto companyDto = null;
        try {
            CompanyModel company = companyMapper.findCompanyByRuc(ruc);
            companyDto = CompanyConverter.modelToDto(company);
        } catch (Exception e) {
            watchLogs(e);
        }
        return companyDto;
    }

    @Override
    public OseDto findOseByRuc(String ruc) {
        OseDto oseDto = null;
        try {
            OseModel ose = companyMapper.findOseByRuc(ruc);
            oseDto = OseConverter.modelToDto(ose);
        } catch (Exception e) {
            watchLogs(e);
        }
        return oseDto;
    }

    public void watchLogs(Exception e) {
        log.error("ERROR: {} ",e.getMessage());
    }

}
