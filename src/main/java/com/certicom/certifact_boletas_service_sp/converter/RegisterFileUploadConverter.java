package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.RegisterFileUploadDto;
import com.certicom.certifact_boletas_service_sp.model.RegisterFileUploadModel;

import java.sql.SQLOutput;

public class RegisterFileUploadConverter {

    public static RegisterFileUploadDto modelToDto(RegisterFileUploadModel registerFileUploadModel) {
        return RegisterFileUploadDto.builder()
                .idRegisterFileSend(registerFileUploadModel.getIdRegisterFileSend())
                .extension(registerFileUploadModel.getExtension())
                .fechaUpload(registerFileUploadModel.getFechaUpload())
                .bucket(registerFileUploadModel.getBucket())
                .nombreOriginal(registerFileUploadModel.getNombreOriginal())
                .nombreGenerado(registerFileUploadModel.getNombreGenerado())
                .rucCompany(registerFileUploadModel.getRucCompany())
                .tipoArchivo(registerFileUploadModel.getTipoArchivo())
                .usuarioUpload(registerFileUploadModel.getUsuarioUpload())
                .uuid(registerFileUploadModel.getUuid())
                .codCompany(registerFileUploadModel.getCodCompany())
                .estado(registerFileUploadModel.getEstado())
                .fechaModificacion(registerFileUploadModel.getFechaModificacion())
                .userNameModify(registerFileUploadModel.getUserNameModify())
                .isOld(registerFileUploadModel.getIsOld())
                .build();
    }

    public static RegisterFileUploadModel dtoToModel(RegisterFileUploadDto registerFileUploadDto) {
        return RegisterFileUploadModel.builder()
                .idRegisterFileSend(registerFileUploadDto.getIdRegisterFileSend())
                .extension(registerFileUploadDto.getExtension())
                .fechaUpload(registerFileUploadDto.getFechaUpload())
                .bucket(registerFileUploadDto.getBucket())
                .nombreOriginal(registerFileUploadDto.getNombreOriginal())
                .nombreGenerado(registerFileUploadDto.getNombreGenerado())
                .rucCompany(registerFileUploadDto.getRucCompany())
                .tipoArchivo(registerFileUploadDto.getTipoArchivo())
                .usuarioUpload(registerFileUploadDto.getUsuarioUpload())
                .uuid(registerFileUploadDto.getUuid())
                .codCompany(registerFileUploadDto.getCodCompany())
                .estado(registerFileUploadDto.getEstado())
                .fechaModificacion(registerFileUploadDto.getFechaModificacion())
                .userNameModify(registerFileUploadDto.getUserNameModify())
                .isOld(registerFileUploadDto.getIsOld())
                .build();
    }


}
