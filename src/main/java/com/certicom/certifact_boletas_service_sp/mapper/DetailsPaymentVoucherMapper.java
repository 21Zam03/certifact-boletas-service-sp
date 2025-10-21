package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.dto.DetailsPaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.model.DetailsPaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailsPaymentVoucherMapper extends BaseMapper<DetailsPaymentVoucherModel, Long> {

    //int save(DetailsPaymentVoucherModel detailsPaymentVoucherModel);
    //int deleteById(Long Id);
    //int update(DetailsPaymentVoucherModel detailsPaymentVoucherModel);
    List<DetailsPaymentVoucherModel> findAllByIdPaymentVoucher(Long id);
    List<DetailsPaymentVoucherModel> findByIdPaymentVoucher(Long idPaymentVoucher);

}
