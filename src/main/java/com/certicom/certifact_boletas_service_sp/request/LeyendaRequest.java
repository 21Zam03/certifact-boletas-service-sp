package com.certicom.certifact_boletas_service_sp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeyendaRequest {

    private String descripcion;
    private String codigo;

}
