package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentVoucherMapper {

    int save(PaymentVoucherModel paymentVoucherModel);
    PaymentVoucherModel findById(Long id);
    PaymentVoucherModel findByIdentificadorDocumento(String idDocumento);
    Integer getNumeroByTipoComprobanteAndSerieAndRucEmisor(String tipo, String serie, String ruc);
    List<PaymentVoucherModel> findListSpecificForSummary(
            String ruc, String fechaEmision, String tipo,
            String  serie, Integer numero
    );

}
