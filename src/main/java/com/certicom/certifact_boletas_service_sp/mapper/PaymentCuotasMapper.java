package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentCuotasModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentCuotasMapper {

    int save(PaymentCuotasModel paymentCuotasModel);
    int deleteById(Long id);
    List<PaymentCuotasModel> findAllByIdPaymentVoucher(Long id);
    int update(PaymentCuotasModel paymentCuotasModel);

}
