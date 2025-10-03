package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.TypeFieldModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeFieldMapper extends BaseMapper<TypeFieldModel, Long> {

    Long getIdByName(String name);

}
