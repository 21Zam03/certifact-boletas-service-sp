package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeFieldModel {

    private Long id;
    private String name;

}
