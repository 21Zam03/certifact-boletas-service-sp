package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.RegisterFileUploadConverter;
import com.certicom.certifact_boletas_service_sp.dto.RegisterFileUploadDto;
import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.RegisterFileUploadMapper;
import com.certicom.certifact_boletas_service_sp.model.RegisterFileUploadModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.RegisterFileUploadService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class RegisterFileUploadServiceImpl extends AbstractGenericService<RegisterFileUploadModel, Long, RegisterFileUploadMapper>
        implements RegisterFileUploadService {

    protected RegisterFileUploadServiceImpl(RegisterFileUploadMapper mapper) {
        super(mapper);
    }

    @Override
    @Transactional
    public RegisterFileUploadDto saveRegisterFileUpload(RegisterFileUploadDto registerFileUpload) {
        return RegisterFileUploadConverter.modelToDto(save(RegisterFileUploadConverter.dtoToModel(registerFileUpload)));
    }

    @Override
    public RegisterFileUploadDto findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(Long idPayment, String tipoArchivo, String estadoArchivo) {
        return null;
    }

    @Override
    public RegisterFileUploadDto getDataForCdr(Long id, String uuid, String tipo) {
        if(id == null || uuid == null || tipo == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "Uno de los parametros id, uuid o tipo son nulos");
            throw new ServiceException(String.format("%s: Uno de los parametros id, uuid o tipo son nulos", LogMessages.ERROR_VALIDATION));
        }
        try {
            RegisterFileUploadModel registerFileUploadModel = mapper.getDataForCdr(id, uuid, tipo);
            if(registerFileUploadModel == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "La variable registerFileUploadModel es nulo");
                return null;
            } else {
                RegisterFileUploadDto registerFileUploadDto = RegisterFileUploadConverter.modelToDto(registerFileUploadModel);
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo con exito, dataForCdr: "+registerFileUploadDto.getNombreGenerado());
                return registerFileUploadDto;
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
    public RegisterFileUploadDto getDataForXml(Long id, String uuid, String tipo) {
        if(id == null || uuid == null || tipo == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "Uno de los parametros id, uuid o tipo son nulos");
            throw new ServiceException(String.format("%s: Uno de los parametros id, uuid o tipo son nulos", LogMessages.ERROR_VALIDATION));
        }
        try {
            RegisterFileUploadModel registerFileUploadModel = mapper.getDataForXml(id, uuid, tipo);
            if(registerFileUploadModel == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "La variable registerFileUploadModel es nulo");
                return null;
            } else {
                RegisterFileUploadDto registerFileUploadDto = RegisterFileUploadConverter.modelToDto(registerFileUploadModel);
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo con exito, dataForXml: "+registerFileUploadDto.getNombreGenerado());
                return registerFileUploadDto;
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

}
