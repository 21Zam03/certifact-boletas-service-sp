package com.certicom.certifact_boletas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RucEstadoOther {

    private String rucEmisor;
    private String estado;

}
