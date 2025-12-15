package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PaymentVoucherMapper extends BaseMapper<PaymentVoucherModel, Long> {

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

    List<PaymentVoucherModel> findAnticipos(
            @Param("tipoComprobante") List<String> tipoComprobante,
            @Param("numDocIdentReceptor") String numDocIdentReceptor,
            @Param("rucEmisor") String rucEmisor,
            @Param("tipoOperacion") String tipoOperacion,
            @Param("estado") String estado
    );

    List<PaymentVoucherModel> findCreditos(
            @Param("numDocIdentReceptor") String numDocIdentReceptor,
            @Param("rucEmisor") String rucEmisor
    );

}
