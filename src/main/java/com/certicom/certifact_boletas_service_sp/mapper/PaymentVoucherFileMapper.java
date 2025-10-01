package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherFileResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentVoucherFileMapper extends BaseMapper<PaymentVoucherFileModel, Long> {

    //int save(PaymentVoucherFileModel paymentVoucherFileModel);
    List<PaymentVoucherFileModel> findAllByIdPaymentVoucher(Long id);
    //int update(PaymentVoucherFileModel paymentVoucherFileModel);

}
