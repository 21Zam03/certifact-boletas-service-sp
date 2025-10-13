package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.PaymentVoucherFileConverter;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherFileDto;
import com.certicom.certifact_boletas_service_sp.mapper.PaymentVoucherFileMapper;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_boletas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherFileService;
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
        return 0;
    }

    @Override
    public void updateAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos) {
        updateAll(PaymentVoucherFileConverter.dtoListToModelList(paymentVoucherFileDtos));
    }


}
