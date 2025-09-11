package com.certicom.certifact_boletas_service_sp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long idUser;
    private Integer idOficina;
    private String nombreUsuario;
    private String contrasena;
    private String nombreCompleto;
    private String dni;
    private String estado;
    private Boolean activo;
    private String ruc;

}
