package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;

public class PaymentVoucherConverter {

    public static PaymentVoucherModel dtoToModel(PaymentVoucherDto paymentVoucherDto) {
        return PaymentVoucherModel.builder()
                .serie(paymentVoucherDto.getSerie())
                .numero(paymentVoucherDto.getNumero())
                .fechaEmision(paymentVoucherDto.getFechaEmision())
                .fechaEmisionDate(paymentVoucherDto.getFechaEmisionDate())
                .horaEmision(paymentVoucherDto.getHoraEmision())
                .tipoComprobante(paymentVoucherDto.getTipoComprobante())
                .codigoMoneda(paymentVoucherDto.getCodigoMoneda())
                .fechaVencimiento(paymentVoucherDto.getFechaVencimiento())
                .tipoOperacion(paymentVoucherDto.getCodigoTipoOperacion())
                .rucEmisor(paymentVoucherDto.getRucEmisor())
                .codigoLocalAnexo(paymentVoucherDto.getCodigoLocalAnexoEmisor())
                .tipoDocIdenReceptor(paymentVoucherDto.getTipoDocumentoReceptor())
                .numDocIdenReceptor(paymentVoucherDto.getNumeroDocumentoReceptor())
                .denominacionReceptor(paymentVoucherDto.getDenominacionReceptor())
                .direccionReceptor(paymentVoucherDto.getDireccionReceptor())
                .emailReceptor(paymentVoucherDto.getEmailReceptor())
                .codigoTipoDocumentoRelacionado(paymentVoucherDto.getCodigoTipoOtroDocumentoRelacionado())
                .serieNumeroDocumentoRelacionado(paymentVoucherDto.getSerieNumeroOtroDocumentoRelacionado())
                .totalValorVentaOperacionExportada(paymentVoucherDto.getTotalValorVentaExportacion())
                .totalValorVentaOperacionGravada(paymentVoucherDto.getTotalValorVentaGravada())
                .totalValorVentaOperacionInafecta(paymentVoucherDto.getTotalValorVentaInafecta())
                .totalValorVentaOperacionExonerada(paymentVoucherDto.getTotalValorVentaExonerada())
                .totalValorVentaOperacionGratuita(paymentVoucherDto.getTotalValorVentaGratuita())
                .totalValorBaseIsc(paymentVoucherDto.getTotalValorBaseIsc())
                .totalValorBaseOtrosTributos(paymentVoucherDto.getTotalValorBaseOtrosTributos())
                .totalValorVentaGravadaIVAP(paymentVoucherDto.getTotalValorVentaGravadaIVAP())
                .totalDescuento(paymentVoucherDto.getTotalDescuento())
                .sumatoriaTributosOperacionGratuita(paymentVoucherDto.getTotalImpOperGratuita())
                .sumatoriaIvap(paymentVoucherDto.getTotalIvap())
                .sumatoriaIgv(paymentVoucherDto.getTotalIgv())
                .sumatoriaIsc(paymentVoucherDto.getTotalIsc())
                .sumatoriaOtrostributos(paymentVoucherDto.getTotalOtrostributos())
                .montoDescuentoGlobal(paymentVoucherDto.getDescuentoGlobales())
                .montoSumatorioOtrosCargos(paymentVoucherDto.getSumatoriaOtrosCargos())
                .montoImporteTotalVenta(paymentVoucherDto.getImporteTotalVenta())
                .montoTotalAnticipos(paymentVoucherDto.getTotalAnticipos())
                .serieAfectado(paymentVoucherDto.getSerieAfectado())
                .numeroAfectado(paymentVoucherDto.getNumeroAfectado())
                .tipoComprobanteAfectado(paymentVoucherDto.getTipoComprobanteAfectado())
                .motivoNota(paymentVoucherDto.getMotivoNota())
                .codigoTipoNotaCredito(paymentVoucherDto.getCodigoTipoNotaCredito())
                .codigoTipoNotaDebito(paymentVoucherDto.getCodigoTipoNotaDebito())
                .identificadorDocumento(paymentVoucherDto.getIdentificadorDocumento())
                .estadoItem(paymentVoucherDto.getEstadoItem())
                .estadoSunat(paymentVoucherDto.getEstadoSunat())
                .estado(paymentVoucherDto.getEstado())
                .estadoAnterior(paymentVoucherDto.getEstadoAnterior())
                .mensajeRespuesta(paymentVoucherDto.getMensajeRespuesta())
                .fechaRegistro(paymentVoucherDto.getFechaRegistro())
                .fechaModificacion(paymentVoucherDto.getFechaModificacion())
                .userName(paymentVoucherDto.getUserName())
                .userNameModify(paymentVoucherDto.getUserNameModificacion())
                .Uuid(paymentVoucherDto.getUuid())
                .ordenCompra(paymentVoucherDto.getOrdenCompra())
                .codigoHash(paymentVoucherDto.getCodigoHash())
                .codigoMedioPago(paymentVoucherDto.getCodigoMedioPago())
                .cuentaFinancieraBeneficiario(paymentVoucherDto.getCuentaFinancieraBeneficiario())
                .codigoBienDetraccion(paymentVoucherDto.getCodigoBienDetraccion())
                .porcentajeDetraccion(paymentVoucherDto.getPorcentajeDetraccion())
                .porcentajeRetencion(paymentVoucherDto.getPorcentajeRetencion())
                .montoDetraccion(paymentVoucherDto.getMontoDetraccion())
                .montoRetencion(paymentVoucherDto.getMontoRetencion())
                .detraccion(paymentVoucherDto.getDetraccion())
                .retencion(paymentVoucherDto.getRetencion())
                .tipoTransaccion(paymentVoucherDto.getTipoTransaccion())
                .montoPendiente(paymentVoucherDto.getMontoPendiente())
                .cantidadCuotas(paymentVoucherDto.getCantidadCuotas())
                .pagoCuenta(paymentVoucherDto.getPagoCuenta())
                .build();
    }

    public static PaymentVoucherResponse ModelToResponse(PaymentVoucherModel paymentVoucherModel) {
        return PaymentVoucherResponse.builder().build();
    }

}
