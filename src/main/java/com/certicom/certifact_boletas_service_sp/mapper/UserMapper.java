package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.dto.UserDto;
import com.certicom.certifact_boletas_service_sp.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserModel findById(Long id);
    UserModel findByUsername(String username);

}
