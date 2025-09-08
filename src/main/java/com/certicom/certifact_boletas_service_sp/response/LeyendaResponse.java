package com.certicom.certifact_boletas_service_sp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeyendaResponse {

    private String descripcion;
    private String codigo;

}
