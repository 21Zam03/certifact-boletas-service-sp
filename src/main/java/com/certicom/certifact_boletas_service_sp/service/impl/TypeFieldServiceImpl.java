package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.TypeFieldMapper;
import com.certicom.certifact_boletas_service_sp.model.TypeFieldModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.TypeFieldService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TypeFieldServiceImpl extends AbstractGenericService<TypeFieldModel, Long, TypeFieldMapper>
        implements TypeFieldService {

    protected TypeFieldServiceImpl(TypeFieldMapper mapper) {
        super(mapper);
    }

    @Override
    public Long getIdByNameTypeField(String name) {
        if(name == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "variable rucEmisor es nulo");
            throw new ServiceException(String.format("%s: el ruc no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            Long id = mapper.getIdByName(name);
            if(id == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "variable id es nulo");
            } else {
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo exitosamente");
            }
            return id;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

}
