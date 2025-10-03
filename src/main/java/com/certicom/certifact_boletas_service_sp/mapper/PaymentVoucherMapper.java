package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PaymentVoucherMapper extends BaseMapper<PaymentVoucherModel, Long> {

    //int insert(PaymentVoucherModel paymentVoucherModel);
    //int update(PaymentVoucherModel paymentVoucherModel);
    //PaymentVoucherModel findById(Long id);

    PaymentVoucherModel findByIdentificadorDocumento(String idDocumento);
    Integer getNumeroByTipoComprobanteAndSerieAndRucEmisor(String tipo, String serie, String ruc);
    List<PaymentVoucherModel> findListSpecificForSummary(
            String ruc, String fechaEmision, String tipo,
            String  serie, Integer numero
    );
    List<PaymentVoucherModel> findAllForSummaryByRucEmisorAndFechaEmision(String rucEmisor, String fechaEmision);
    int updateStateToSendSunatForSummaryDocuments(List<Long> ids, String usuario, Timestamp fechaModificacion);
    int updateComprobantesBySummaryDocuments(List<String> identificadorComprobantes, String estado, String estadoSunat, String usuario,
                                             Timestamp fechaModificacion);
    int updateComprobantesOnResumenError(
            List<String> identificadoresComprobantes,
            String usuario,
            Timestamp fechaModificacion);

    PaymentVoucherModel findByRucAndTipoAndSerieAndNumero(
            String finalRucEmisor,
            String tipoComprobante,
            String serie,
            Integer numero);
}
