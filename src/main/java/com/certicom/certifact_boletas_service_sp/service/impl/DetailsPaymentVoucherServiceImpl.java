package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.DetailsPaymentVoucherConverter;
import com.certicom.certifact_boletas_service_sp.dto.DetailsPaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.mapper.DetailsPaymentVoucherMapper;
import com.certicom.certifact_boletas_service_sp.model.DetailsPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.DetailsPaymentVoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DetailsPaymentVoucherServiceImpl extends AbstractGenericService<DetailsPaymentVoucherModel, Long, DetailsPaymentVoucherMapper>
            implements DetailsPaymentVoucherService {

    protected DetailsPaymentVoucherServiceImpl(DetailsPaymentVoucherMapper mapper) {
        super(mapper);
    }

    @Override
    public void updateAllDetailsPaymentVouhcer(List<DetailsPaymentVoucherDto> detailsPaymentVoucherDtoList) {
        mapper.updateAll(DetailsPaymentVoucherConverter.detoListToModelList(detailsPaymentVoucherDtoList));
    }

}
