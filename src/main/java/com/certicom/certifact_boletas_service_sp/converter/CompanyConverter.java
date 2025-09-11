package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.dto.CompanyDto;
import com.certicom.certifact_boletas_service_sp.model.CompanyModel;

public class CompanyConverter {

    public static CompanyDto modelToDto(CompanyModel companyModel) {
        return CompanyDto.builder()
                .id(companyModel.getId())
                .ruc(companyModel.getRuc())
                .viewCode(companyModel.getViewCode())
                .razon(companyModel.getRazon())
                .email(companyModel.getEmail())
                .telefono(companyModel.getTelefono())
                .cadena(companyModel.getCadena())
                .rubroHoreal(companyModel.getRubroHoreal())
                .nombreComer(companyModel.getNombreComer())
                .ublVersion(companyModel.getUblVersion())
                .oseId(companyModel.getOseId())
                .bucket(companyModel.getBucket())
                .envioAutomaticoSunat(companyModel.getEnvioAutomaticoSunat())
                .envioAutomaticoGuia(companyModel.getEnvioAutomaticoGuia())
                .envioAutomaticoReteperse(companyModel.getEnvioAutomaticoReteperse())
                .envioDirecto(companyModel.getEnvioDirecto())
                .direccion(companyModel.getDireccion())
                .simultaneo(companyModel.getSimultaneo())
                .allowSaveOficina(companyModel.getAllowSaveOficina())
                .cantComproDina(companyModel.getCantComproDina())
                .idRegisterFileSend(companyModel.getIdRegisterFileSend())
                .format(companyModel.getFormat())
                .build();
    }

}
