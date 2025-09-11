package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OseModel {

    private Integer osesId;
    private String nameOses;
    private String urlFacturas;
    private String urlGuias;
    private String urlRetencion;
    private String urlConsultaCdr;
    private String urlOthercpe;

}
