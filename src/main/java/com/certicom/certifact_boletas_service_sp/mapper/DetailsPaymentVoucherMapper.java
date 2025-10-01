package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.DetailsPaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailsPaymentVoucherMapper {

    int save(DetailsPaymentVoucherModel detailsPaymentVoucherModel);
    int deleteById(Long Id);
    List<DetailsPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);
    int update(DetailsPaymentVoucherModel detailsPaymentVoucherModel);

}
