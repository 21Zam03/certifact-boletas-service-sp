package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.CompanyConverter;
import com.certicom.certifact_boletas_service_sp.converter.OseConverter;
import com.certicom.certifact_boletas_service_sp.dto.CompanyDto;
import com.certicom.certifact_boletas_service_sp.dto.OseDto;
import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.CompanyMapper;
import com.certicom.certifact_boletas_service_sp.model.CompanyModel;
import com.certicom.certifact_boletas_service_sp.model.OseModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.CompanyService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyServiceImpl extends AbstractGenericService<CompanyModel, Long, CompanyMapper>
        implements CompanyService {

    protected CompanyServiceImpl(CompanyMapper mapper) {
        super(mapper);
    }

    @Override
    public String getEstadoByRuc(String rucEmisor) {
        if(rucEmisor == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "variable rucEmisor es nulo");
            throw new ServiceException(String.format("%s: el ruc no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            String estado = mapper.getEstadoByRuc(rucEmisor);
            if(estado == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "variable estado es nulo");
            } else {
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo exitosamente, parametro[estado]="+estado);
            }
            return estado;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public CompanyDto findByRuc(String ruc) {
        if(ruc == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "variable ruc es nulo");
            throw new ServiceException(String.format("%s: el ruc no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            CompanyModel company = mapper.findCompanyByRuc(ruc);
            if(company == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "variable company es nulo");
                return null;
            } else {
                CompanyDto companyDto = CompanyConverter.modelToDto(company);
                LogHelper.infoLog(LogMessages.currentMethod(),
                        "La consulta se realizo exitosamente, parametro[company_ruc]="+company.getRuc());
                return companyDto;
            }
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public OseDto findOseByRuc(String ruc) {
        if(ruc == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "variable ruc es nulo");
            throw new ServiceException(String.format("%s: el ruc no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            OseModel ose = mapper.findOseByRuc(ruc);
            if(ose == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "variable ose es nulo");
                return null;
            } else {
                OseDto oseDto = OseConverter.modelToDto(ose);
                LogHelper.infoLog(LogMessages.currentMethod(),
                        "La consulta se realizo exitosamente, parametro[ose_id]="+oseDto.getId());
                return oseDto;
            }
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        } catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

}
