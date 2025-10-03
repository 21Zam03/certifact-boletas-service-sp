package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.GuiaPaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuiaPaymentVoucherMapper extends BaseMapper<GuiaPaymentVoucherModel, Long> {

    int save(GuiaPaymentVoucherModel guiaPaymentVoucherModel);
    int deleteById(Long id);
    List<GuiaPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);
    int update(GuiaPaymentVoucherModel guiaPaymentVoucherModel);

}
