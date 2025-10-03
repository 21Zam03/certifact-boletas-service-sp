package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.AditionalFIeldPaymentVoucherConverter;
import com.certicom.certifact_boletas_service_sp.dto.AditionalFieldPaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.AditionalFieldPaymentVoucherMapper;
import com.certicom.certifact_boletas_service_sp.model.AditionalFieldPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.AditionalFieldPaymentVoucherService;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AditionalFieldPaymentVoucherServiceImpl extends AbstractGenericService<AditionalFieldPaymentVoucherModel, Long, AditionalFieldPaymentVoucherMapper>
        implements AditionalFieldPaymentVoucherService {

    protected AditionalFieldPaymentVoucherServiceImpl(AditionalFieldPaymentVoucherMapper mapper) {
        super(mapper);
    }

    @Override
    public void updateAllAditionalFieldPaymentVoucher(List<AditionalFieldPaymentVoucherDto> aditionalFieldPaymentVoucherDtoList) {
        mapper.updateAll(AditionalFIeldPaymentVoucherConverter.dtoListToModelList(aditionalFieldPaymentVoucherDtoList));
    }

}
