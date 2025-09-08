package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.GuiaPaymentVoucherModel;

import java.util.List;

public interface GuiaPaymentVoucherMapper {

    int save(GuiaPaymentVoucherModel guiaPaymentVoucherModel);
    int deleteById(Long id);
    List<GuiaPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);

}
