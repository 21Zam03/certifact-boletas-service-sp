package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.PaymentCuotasConverter;
import com.certicom.certifact_boletas_service_sp.dto.PaymentCuotasDto;
import com.certicom.certifact_boletas_service_sp.mapper.PaymentCuotasMapper;
import com.certicom.certifact_boletas_service_sp.model.PaymentCuotasModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.PaymentCuotasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaymentCuotasServiceImpl extends AbstractGenericService<PaymentCuotasModel, Long, PaymentCuotasMapper>
        implements PaymentCuotasService {

    protected PaymentCuotasServiceImpl(PaymentCuotasMapper mapper) {
        super(mapper);
    }

    @Override
    public void updateAllPaymentCuotas(List<PaymentCuotasDto> paymentCuotasDtoList) {
        mapper.updateAll(PaymentCuotasConverter.dtoListToModelList(paymentCuotasDtoList));
    }

}
