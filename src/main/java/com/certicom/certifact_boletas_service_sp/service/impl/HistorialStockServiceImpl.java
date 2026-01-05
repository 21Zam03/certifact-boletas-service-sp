package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.HistorialStockMapper;
import com.certicom.certifact_boletas_service_sp.model.HistorialStockModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.HistorialStockService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class HistorialStockServiceImpl extends AbstractGenericService<HistorialStockModel, Long, HistorialStockMapper>
        implements HistorialStockService {

    protected HistorialStockServiceImpl(HistorialStockMapper mapper) {
        super(mapper);
    }

    @Override
    public Integer deleteHistorialStockByIdDetailsPayment(Long idDetailsPayment) {
        if(idDetailsPayment == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "variable idDetailsPayment es nulo");
            throw new ServiceException(String.format("%s: el idDetailsPayment no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            int result = mapper.deleteByDetailsPaymentVoucher(idDetailsPayment);
            if(result != 1) {
                LogHelper.warnLog(LogMessages.currentMethod(), "No se pudo eliminar");
            } else {
                LogHelper.infoLog(LogMessages.currentMethod(), "Eliminacion exitosa");
            }
            return result;
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
