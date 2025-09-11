package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.UserDto;
import com.certicom.certifact_boletas_service_sp.model.UserModel;

public class UserConverter {

    public static UserDto modelToDto(UserModel userModel) {
        return UserDto.builder()
                .idUser(userModel.getIdUser())
                .idOficina(userModel.getIdOficina())
                .nombreUsuario(userModel.getNombreUsuario())
                .contrasena(userModel.getContrasena())
                .nombreCompleto(userModel.getNombreCompleto())
                .dni(userModel.getDni())
                .estado(userModel.getEstado())
                .activo(userModel.getActivo())
                .ruc(userModel.getRuc())
                .build();
    }

}
