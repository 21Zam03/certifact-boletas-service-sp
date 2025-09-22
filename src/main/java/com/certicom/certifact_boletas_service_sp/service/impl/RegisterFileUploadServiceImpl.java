package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.RegisterFileUploadConverter;
import com.certicom.certifact_boletas_service_sp.dto.RegisterFileUploadDto;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.RegisterFileUploadMapper;
import com.certicom.certifact_boletas_service_sp.model.RegisterFileUploadModel;
import com.certicom.certifact_boletas_service_sp.service.RegisterFileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterFileUploadServiceImpl implements RegisterFileUploadService {

    private final RegisterFileUploadMapper registerFileUploadMapper;

    @Override
    @Transactional
    public RegisterFileUploadDto save(RegisterFileUploadDto registerFileUpload) {
        RegisterFileUploadDto registerFileUploadDto = null;
        RegisterFileUploadModel registerFileUploadModel = null;
        try {
            RegisterFileUploadModel registerFileUploadModelToCreate = RegisterFileUploadConverter.dtoToModel(registerFileUpload);
            int result = registerFileUploadMapper.save(registerFileUploadModelToCreate);
            if(result < 1) {
                throw new ServiceException("Error al guardar el archivo en la base de datos");
            }
            registerFileUploadModel = registerFileUploadMapper.findById(registerFileUploadModelToCreate.getIdRegisterFileSend());
            if(registerFileUploadModel == null) {
                throw new ServiceException("Error al guardar el archivo en la base de datos");
            }
            registerFileUploadDto = RegisterFileUploadConverter.modelToDto(registerFileUploadModel);
        } catch (Exception e) {
            watchLogs(e);
        }
        return registerFileUploadDto;
    }

    @Override
    public RegisterFileUploadDto findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(Long idPayment, String tipoArchivo, String estadoArchivo) {
        return null;
    }

    @Override
    public RegisterFileUploadDto getDataForCdr(Long id, String uuid, String tipo) {
        RegisterFileUploadDto registerFileUploadDto = null;
        try {
            RegisterFileUploadModel registerFileUploadModel = registerFileUploadMapper.getDataForCdr(id, uuid, tipo);
            registerFileUploadDto = RegisterFileUploadConverter.modelToDto(registerFileUploadModel);
        } catch (Exception e) {
            watchLogs(e);
        }
        return registerFileUploadDto;
    }

    @Override
    public RegisterFileUploadDto getDataForXml(Long id, String uuid, String tipo) {
        RegisterFileUploadDto registerFileUploadDto = null;
        try {
            RegisterFileUploadModel registerFileUploadModel = registerFileUploadMapper.getDataForXml(id, uuid, tipo);
            registerFileUploadDto = RegisterFileUploadConverter.modelToDto(registerFileUploadModel);
        } catch (Exception e) {
            watchLogs(e);
        }
        return registerFileUploadDto;
    }

    public void watchLogs(Exception e) {
        log.error("ERROR: {}", e.getMessage());
    }

}
