package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.TypeFieldMapper;
import com.certicom.certifact_boletas_service_sp.model.TypeFieldModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.TypeFieldService;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import lombok.extern.slf4j.Slf4j;
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
        try {
            if(name == null) {
                log.error(LogMessages.PARAMETER_NOT_NULL);
                throw new ServiceException(LogMessages.PARAMETER_NOT_NULL);
            }
            Long id = mapper.getIdByName(name);
            if(id == null) {
                log.error(LogMessages.RESULT_NULL);
                throw new ServiceException(LogMessages.RESULT_NULL);
            }
            return mapper.getIdByName(name);
        } catch (Exception e) {
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e.getMessage());
        }
    }

}
