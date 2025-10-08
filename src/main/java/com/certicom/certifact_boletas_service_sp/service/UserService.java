package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.UserDto;

public interface UserService {

    UserDto findUserById(Long id);
    UserDto findByUsername(String username);

}
