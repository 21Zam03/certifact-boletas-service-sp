package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentVoucherMapper {

    int save(PaymentVoucherModel paymentVoucherModel);
    PaymentVoucherModel findById(Long id);
    PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento);

}
