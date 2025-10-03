package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.BaseMapper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractGenericService<T, ID, M extends BaseMapper<T, ID>>
        implements GenericService<T, ID> {

    protected final M mapper;
    protected AbstractGenericService(M mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<T> findById(ID id) {
        if(id == null) {
            log.error(LogMessages.PARAMETER_NOT_NULL);
            throw new ServiceException(LogMessages.PARAMETER_NOT_NULL);
        }
        try {
            T entity = mapper.findById(id);
            if (entity == null) {
                log.warn(LogMessages.ENTITY_NOT_FOUND, id);
            }
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            log.error(LogMessages.ENTITY_FOUND_ERROR, e.getMessage());
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e);
        }
    }

    @Override
    public List<T> findAll() {
        try {
            List<T> list = mapper.findAll();
            if(list.isEmpty()) {
                log.warn(LogMessages.ENTITY_LIST_EMPTY);
            }
            return list;
        } catch (Exception e) {
            log.error(LogMessages.ENTITY_LIST_ERROR, e.getMessage());
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e);
        }
    }

    @Override
    public int save(T entity) {
        if(entity == null) {
            log.error(LogMessages.PARAMETER_NOT_NULL);
            throw new ServiceException(LogMessages.PARAMETER_NOT_NULL);
        }
        try {
            int result = mapper.insert(entity);
            if(result < 1) {
                log.warn(LogMessages.ENTITY_NOT_CREATED, entity);
            }
            return result;
        } catch (Exception e) {
            log.error(LogMessages.ENTITY_SAVE_ERROR, e.getMessage());
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e);
        }
    }

    @Override
    public int update(T entity) {
        try {
            int result = mapper.update(entity);
            if(result < 1) {
                log.warn(LogMessages.ENTITY_NOT_UPDATED, entity);
            }
            return result;
        } catch (Exception e) {
            log.error(LogMessages.ENTITY_UPDATE_ERROR, e.getMessage());
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e);
        }
    }

    @Override
    public void delete(ID id) {
        try {
            int result = mapper.deleteById(id);
            if(result < 1) {
                log.warn(LogMessages.ENTITY_NOT_DELETED);
                throw new ServiceException(LogMessages.ENTITY_NOT_DELETED);
            }
        } catch (Exception e) {
            log.error(LogMessages.ENTITY_DELETE_ERROR, e.getMessage());
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e);
        }
    }

    @Override
    public int updateAll(List<T> list) {
        int updatedCount = 0;
        try {
            updatedCount = mapper.updateAll(list);
            if(updatedCount == 0) {
                log.warn(LogMessages.ENTITY_LIST_NOT_UPDATED);
            }
            log.info(LogMessages.ENTITY_LIST_UPDATED, updatedCount);
        } catch (Exception e) {
            log.error(LogMessages.ENTITY_LIST_UPDATED_ERROR, e.getMessage());
            throw new ServiceException(LogMessages.ERROR_EXCEPTION+e);
        }
        return updatedCount;
    }

}
