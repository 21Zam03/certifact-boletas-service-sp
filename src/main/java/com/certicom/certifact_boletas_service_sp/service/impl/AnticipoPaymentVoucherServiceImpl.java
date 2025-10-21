package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.AnticipoPaymentVoucherConverter;
import com.certicom.certifact_boletas_service_sp.dto.AnticipoPaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.mapper.AnticipoPaymentVoucherMapper;
import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.AnticipoPaymentVoucherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnticipoPaymentVoucherServiceImpl extends AbstractGenericService<AnticipoPaymentVoucherModel, Long, AnticipoPaymentVoucherMapper>
        implements AnticipoPaymentVoucherService {

    protected AnticipoPaymentVoucherServiceImpl(AnticipoPaymentVoucherMapper mapper) {
        super(mapper);
    }

    @Override
    public void updateAnticipoPaymentVoucher(AnticipoPaymentVoucherDto anticipoPaymentVoucherDto) {
        update(AnticipoPaymentVoucherConverter.dtoToModel(anticipoPaymentVoucherDto));
    }

    @Override
    public void updateAllAnticipoPaymentVoucher(List<AnticipoPaymentVoucherDto> anticipoPaymentVoucherDtos) {
        updateAll(AnticipoPaymentVoucherConverter.dtoListToModelList(anticipoPaymentVoucherDtos));
    }

    @Override
    public int deleteAnticipoPaymentVoucherById(Long id) {
        return delete(id);
    }

    @Override
    public int saveAllAnticipoPaymentVoucher(List<AnticipoPaymentVoucherDto> anticipos) {
        return saveAll(AnticipoPaymentVoucherConverter.dtoListToModelList(anticipos));
    }

}
