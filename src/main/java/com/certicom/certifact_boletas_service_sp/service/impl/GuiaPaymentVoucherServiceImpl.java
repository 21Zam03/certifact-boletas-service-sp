package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.GuiaPaymentVoucherConverter;
import com.certicom.certifact_boletas_service_sp.dto.GuiaPaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.mapper.GuiaPaymentVoucherMapper;
import com.certicom.certifact_boletas_service_sp.model.GuiaPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.GuiaPaymentVoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GuiaPaymentVoucherServiceImpl extends AbstractGenericService<GuiaPaymentVoucherModel, Long, GuiaPaymentVoucherMapper>
        implements GuiaPaymentVoucherService {


    protected GuiaPaymentVoucherServiceImpl(GuiaPaymentVoucherMapper mapper) {
        super(mapper);
    }

    @Override
    public void updateGuiaPaymentVoucher(List<GuiaPaymentVoucherDto> guiaPaymentVoucherDtoList) {
        mapper.updateAll(GuiaPaymentVoucherConverter.dtoListToModelList(guiaPaymentVoucherDtoList));
    }

}
