package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnticipoPaymentVoucherMapper {

    int save(AnticipoPaymentVoucherModel anticipoPaymentVoucherModel);
    int deleteById(Long id);
    List<AnticipoPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);

}
