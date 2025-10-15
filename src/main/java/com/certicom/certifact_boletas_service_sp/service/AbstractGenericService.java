package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.BaseMapper;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

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
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(), LogMessages.currentMethod(), "parametro id es nulo");
            throw new ServiceException(String.format("%s: el id no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            T entity = mapper.findById(id);
            if(entity == null) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(), LogMessages.currentMethod(), "variable entity es nulo");
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(), LogMessages.currentMethod(), "La consulta se realizo exitosamente");
            }
            return Optional.ofNullable(entity);
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(), LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(), LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public List<T> findAll() {
        try {
            List<T> list = mapper.findAll();
            if(list.isEmpty()) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(), LogMessages.currentMethod(), "La lista esta vacia");
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(), LogMessages.currentMethod(), "La consulta se realizo exitosamente, parametro[list]="+list);
            }
            return list;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(), LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(), LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public T save(T entity) {
        if(entity == null) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(),
                    LogMessages.currentMethod(), "parametro entity no puede ser nulo");
            throw new ServiceException(String.format("%s: la entidad no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            int result = mapper.insert(entity);
            if(result == 0) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(),
                        LogMessages.currentMethod(), "No se registro la entidad");
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(),
                        LogMessages.currentMethod(), "El registro se realizo exitosamente");
            }
            return entity;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public int update(T entity) {
        if(entity == null) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(),
                    LogMessages.currentMethod(), "parametro entity es nulo");
            throw new ServiceException(String.format("%s: la entidad no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            int result = mapper.update(entity);
            if(result == 0) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(),
                        LogMessages.currentMethod(), "No se actualizo la entidad");
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(),
                        LogMessages.currentMethod(), "La actualizacion se realizo exitosamente");
            }
            return result;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public int delete(ID id) {
        if(id == null) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(),
                    LogMessages.currentMethod(), "parametro id es nulo");
            throw new ServiceException(String.format("%s: el id no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            int result = mapper.deleteById(id);
            if(result == 0) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(),
                        LogMessages.currentMethod(), "No se pudo eliminar");
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(),
                        LogMessages.currentMethod(), "Eliminacion exitosa");
            }
            return result;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public int updateAll(List<T> list) {
        if(list == null || list.isEmpty()) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(),
                    LogMessages.currentMethod(), "La lista es nulo o esta vacia");
            throw new ServiceException(String.format("%s: lista es nulo o esta vacia", LogMessages.ERROR_VALIDATION));
        }
        try {
            int expectedRows = list.size();
            int updatedRows = mapper.updateAll(list);
            if(updatedRows != expectedRows) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(),
                        LogMessages.currentMethod(), "filas="+expectedRows+", filasActualizadas="+updatedRows);
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(),
                        LogMessages.currentMethod(), "filas="+expectedRows+", filasActualizadas="+updatedRows);
            }
            return updatedRows;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(),
                    LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

}
