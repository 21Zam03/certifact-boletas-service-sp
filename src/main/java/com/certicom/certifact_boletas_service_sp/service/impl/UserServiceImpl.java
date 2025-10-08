package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.UserConverter;
import com.certicom.certifact_boletas_service_sp.dto.UserDto;
import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.UserMapper;
import com.certicom.certifact_boletas_service_sp.model.UserModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.UserService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl extends AbstractGenericService<UserModel, Long, UserMapper>
        implements UserService {

    protected UserServiceImpl(UserMapper mapper) {
        super(mapper);
    }

    @Override
    public UserDto findUserById(Long idUsuario) {
        UserModel userModel = findById(idUsuario).orElseThrow(() -> new ServiceException("No se encontro usuario con id"+idUsuario));
        return UserConverter.modelToDto(userModel);
    }

    @Override
    public UserDto findByUsername(String username) {
        if(username == null) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(),
                    LogMessages.currentMethod(), "El parametro username es nulo");
            throw new ServiceException(String.format("%s: el username es nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            UserModel user = mapper.findByUsername(username);
            if(user == null) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(),
                        LogMessages.currentMethod(), "La variable user es nulo");
                return null;
            } else {
                UserDto userDto = UserConverter.modelToDto(user);
                LogHelper.infoLog(LogTitle.INFO.getType(),
                        LogMessages.currentMethod(), "La consulta se realizo exitosamente, idUser:"+user.getIdUser());
                return userDto;
            }
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(), LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(), LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

}
