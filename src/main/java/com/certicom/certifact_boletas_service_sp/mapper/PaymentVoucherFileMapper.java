package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherFileModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentVoucherFileMapper extends BaseMapper<PaymentVoucherFileModel, Long> {

    List<PaymentVoucherFileModel> findAllByIdPaymentVoucher(Long id);

}
