package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.AditionalFieldPaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AditionalFieldPaymentVoucherMapper extends BaseMapper<AditionalFieldPaymentVoucherModel, Long> {

    //int save(AditionalFieldPaymentVoucherModel aditionalFieldPaymentVoucherModel);
    //int deleteById(Long id);
    //int update(AditionalFieldPaymentVoucherModel aditionalFieldPaymentVoucherModel);
    List<AditionalFieldPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);

}
