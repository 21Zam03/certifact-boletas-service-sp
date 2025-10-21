package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.PaymentVoucherFileConverter;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherFileDto;
import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.PaymentVoucherFileMapper;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherFileService;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentVoucherFileImpl extends AbstractGenericService<PaymentVoucherFileModel, Long, PaymentVoucherFileMapper>
        implements PaymentVoucherFileService {

    protected PaymentVoucherFileImpl(PaymentVoucherFileMapper mapper) {
        super(mapper);
    }

    @Override
    public PaymentVoucherFileDto savePaymentVoucherFile(PaymentVoucherFileDto paymentVoucherFileDto) {
        PaymentVoucherFileModel p = save(PaymentVoucherFileConverter.dtoToModel(paymentVoucherFileDto));
        return PaymentVoucherFileConverter.modelToDto(p);
    }

    @Override
    public int updatePaymentVoucherFile(PaymentVoucherFileDto paymentVoucherFileDto) {
        return update(PaymentVoucherFileConverter.dtoToModel(paymentVoucherFileDto));
    }

    @Override
    public int saveAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos) {
        return saveAll(PaymentVoucherFileConverter.dtoListToModelList(paymentVoucherFileDtos));
    }

    @Override
    public void updateAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos) {
        updateAll(PaymentVoucherFileConverter.dtoListToModelList(paymentVoucherFileDtos));
    }

    @Override
    public int deleteAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos) {
        return deleteAll(PaymentVoucherFileConverter.dtoListToModelList(paymentVoucherFileDtos));
    }

    @Override
    public List<PaymentVoucherFileDto> findAllByIdPaymentVoucher(Long id) {
        if(id == null) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(),
                    LogMessages.currentMethod(), "parametro id no puede ser nulo");
            throw new ServiceException(String.format("%s: parametro id no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
       try {
           List<PaymentVoucherFileModel> list = mapper.findAllByIdPaymentVoucher(id);
           if(list == null || list.isEmpty()) {
               LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(),
                       LogMessages.currentMethod(), "La lista es nulo o esta vacia");
               return null;
           } else {
               List<PaymentVoucherFileDto> listDto = PaymentVoucherFileConverter.modelListToDtoList(list);
               LogHelper.infoLog(LogTitle.INFO.getType(),
                       LogMessages.currentMethod(), "La consulta se realizo exitosamente");
               return listDto;
           }
       } catch (DataAccessException | PersistenceException e) {
           LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(),
                   LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
           throw new ServiceException(LogMessages.ERROR_DATABASE, e);
       }
       catch (Exception e) {
           LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(),
                   LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
           throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
       }
    }

}
