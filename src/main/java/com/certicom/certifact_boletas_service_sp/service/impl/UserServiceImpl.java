package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.UserConverter;
import com.certicom.certifact_boletas_service_sp.dto.UserDto;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.UserMapper;
import com.certicom.certifact_boletas_service_sp.model.UserModel;
import com.certicom.certifact_boletas_service_sp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserDto findById(Long idUsuario) {
        UserDto usuario = null;
        if (idUsuario != null) {
            try {
                UserModel user =  userMapper.findById(idUsuario);
                usuario = UserConverter.modelToDto(user);
            } catch (Exception e) {
                watchLogs(e);
            }
        } else {
            throw new ServiceException("idUsuario is null");
        }
        return usuario;
    }

    @Override
    public UserDto findByUsername(String username) {
        UserDto userDto = null;
        try {
            UserModel user = userMapper.findByUsername(username);
            userDto = UserConverter.modelToDto(user);
        } catch (Exception e) {
            watchLogs(e);
        }
        return userDto;
    }

    public void watchLogs(Exception e) {
        log.error("ERROR: {} ",e.getMessage());
    }
}
