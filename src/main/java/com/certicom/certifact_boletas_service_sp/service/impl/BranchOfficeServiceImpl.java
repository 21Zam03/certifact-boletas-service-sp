package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.BranchOfficeConverter;
import com.certicom.certifact_boletas_service_sp.dto.BranchOfficeDto;
import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.BranchOfficeMapper;
import com.certicom.certifact_boletas_service_sp.model.BranchOfficeModel;
import com.certicom.certifact_boletas_service_sp.service.BranchOfficeService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchOfficeServiceImpl implements BranchOfficeService {

    private final BranchOfficeMapper branchOfficeMapper;

    @Override
    public BranchOfficeDto findByCompanyIdAndSerieAndTipoComprobante(Integer empresaId, String serie, String tipoComprobante) {
        if(empresaId == null || serie == null || tipoComprobante == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "uno o varios de los parametros: empresaId, serie o tipoComprobante son nulos");
            throw new ServiceException(String.format("%s: uno o varios de los parametros: empresaId, serie o tipoComprobante son nulos", LogMessages.ERROR_VALIDATION));
        }
        try {
            BranchOfficeModel branchOfficeModel = branchOfficeMapper.findByCompanyIdAndSerieAndTipoComprobante(empresaId, serie, tipoComprobante);
            if(branchOfficeModel == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "La variable branchOfficeModel es nulo, " +
                                "[empresaId="+empresaId+", serie="+serie+", tipoComprobante="+tipoComprobante+"]");
                return null;
            } else {
                BranchOfficeDto branchOfficeDto = BranchOfficeConverter.modelToDto(branchOfficeModel);
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo con exito");
                return branchOfficeDto;
            }
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

}
