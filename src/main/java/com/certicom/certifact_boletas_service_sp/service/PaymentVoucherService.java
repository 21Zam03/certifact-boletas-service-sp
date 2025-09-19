package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;

import java.sql.Timestamp;
import java.util.List;

public interface PaymentVoucherService {

    PaymentVoucherDto save(PaymentVoucherDto paymentVoucherDto);
    PaymentVoucherDto update(PaymentVoucherDto paymentVoucherDto);
    int delete(Long id);
    PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento);
    Integer getNumeracion(String tipoComprobante, String serie, String ruc);
    List<PaymentVoucherDto> findListSpecificForSummary(
            String ruc, String fechaEmision, String tipo,
            String  serie, Integer numero
    );
    List<PaymentVoucherDto> findAllForSummaryByRucEmisorAndFechaEmision(String rucEmisor, String fechaEmision);
    int updateStateToSendSunatForSummaryDocuments(List<Long> ids, String usuario, Timestamp fechaModificacion);
    int updateComprobantesBySummaryDocuments(List<String> identificadorComprobantes, String estado, String estadoSunat, String usuario,
                                             Timestamp fechaModificacion);
    int updateComprobantesOnResumenError(
            List<String> identificadoresComprobantes,
            String usuario,
            Timestamp fechaModificacion);

    PaymentVoucherDto findByRucAndTipoAndSerieAndNumero(
            String finalRucEmisor,
            String tipoComprobante,
            String serie,
            Integer numero);
}
