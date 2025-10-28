package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.HistorialStockModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistorialStockMapper extends BaseMapper<HistorialStockModel, Long> {

    int deleteByDetailsPaymentVoucher(Long idDetailsPayment);

}
