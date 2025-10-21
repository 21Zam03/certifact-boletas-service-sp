package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentCuotasModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentCuotasMapper extends BaseMapper<PaymentCuotasModel, Long>{

    //int save(PaymentCuotasModel paymentCuotasModel);
    //int deleteById(Long id);
    //int update(PaymentCuotasModel paymentCuotasModel);
    List<PaymentCuotasModel> findAllByIdPaymentVoucher(Long id);
    List<PaymentCuotasModel> listCuotasByIdPaymentVoucher(Long idPaymentVoucher);

}
