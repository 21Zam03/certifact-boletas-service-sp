package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.dto.AnticipoPaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnticipoPaymentVoucherMapper extends BaseMapper<AnticipoPaymentVoucherModel, Long> {

    int insert(AnticipoPaymentVoucherModel anticipoPaymentVoucherModel);
    int deleteById(Long id);
    List<AnticipoPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);

    List<AnticipoPaymentVoucherModel> listAnticiposByIdPaymentVoucher(Long id);
    //int update(AnticipoPaymentVoucherModel anticipoPaymentVoucherModel);

}
