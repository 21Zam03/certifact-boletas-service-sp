package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.PaymentVoucherFileConverter;
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
    public int savePaymentVoucherFile(PaymentVoucherFileDto paymentVoucherFileDto) {
        return mapper.insert(PaymentVoucherFileConverter.dtoToModel(paymentVoucherFileDto));
    }

    @Override
    public int updatePaymentVoucherFile(PaymentVoucherFileDto paymentVoucherFileDto) {
        return mapper.update(PaymentVoucherFileConverter.dtoToModel(paymentVoucherFileDto));
    }

    @Override
    public int saveAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos) {
        return 0;
    }

    @Override
    public void updateAllPaymentVoucherFile(List<PaymentVoucherFileDto> paymentVoucherFileDtos, Long idPaymentVoucher) {
        if (paymentVoucherFileDtos!=null && !paymentVoucherFileDtos.isEmpty()) {
            for (PaymentVoucherFileDto paymentVoucherFileDto : paymentVoucherFileDtos) {
                paymentVoucherFileDto.setIdPaymentVoucher(idPaymentVoucher);
            }
            mapper.updateAll(PaymentVoucherFileConverter.dtoListToModelList(paymentVoucherFileDtos));
        }
    }


}
