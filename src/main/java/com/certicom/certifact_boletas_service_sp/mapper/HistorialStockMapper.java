package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.HistorialStockModel;

public interface HistorialStockMapper extends BaseMapper<HistorialStockModel, Long> {

    int deleteByDetailsPaymentVoucher(Long idDetailsPayment);

}
