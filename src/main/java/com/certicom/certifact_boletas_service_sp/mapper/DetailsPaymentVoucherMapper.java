package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.DetailsPaymentVoucherModel;

import java.util.List;

public interface DetailsPaymentVoucherMapper {

    int save(DetailsPaymentVoucherModel detailsPaymentVoucherModel);
    int deleteById(Long Id);
    List<DetailsPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);

}
