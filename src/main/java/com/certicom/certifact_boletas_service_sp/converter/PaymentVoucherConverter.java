package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentVoucherConverter {

    public static PaymentVoucherModel dtoToModel(PaymentVoucherDto paymentVoucherDto) {
        if (paymentVoucherDto == null) {
            return null;
        }
        return PaymentVoucherModel.builder()
                .idPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher())
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
                .tipDocIdentReceptor(paymentVoucherDto.getTipoDocumentoReceptor())
                .numDocIdentReceptor(paymentVoucherDto.getNumeroDocumentoReceptor())
                .denominacionReceptor(paymentVoucherDto.getDenominacionReceptor())
                .direccionReceptor(paymentVoucherDto.getDireccionReceptor())
                .emailReceptor(paymentVoucherDto.getEmailReceptor())
                .codigoTipoDocumentoRelacionado(paymentVoucherDto.getCodigoTipoOtroDocumentoRelacionado())
                .serieNumeroDocumentoRelacionado(paymentVoucherDto.getSerieNumeroOtroDocumentoRelacionado())
                .totalOperExportada(paymentVoucherDto.getTotalValorVentaExportacion())
                .totalOperGravada(paymentVoucherDto.getTotalValorVentaGravada())
                .totalOperInafecta(paymentVoucherDto.getTotalValorVentaInafecta())
                .totalOperExonerada(paymentVoucherDto.getTotalValorVentaExonerada())
                .totalOperGratuita(paymentVoucherDto.getTotalValorVentaGratuita())
                .totalValorBaseIsc(paymentVoucherDto.getTotalValorBaseIsc())
                .totalValorBaseOtrosTributos(paymentVoucherDto.getTotalValorBaseOtrosTributos())
                .totalValorVentaGravadaIVAP(paymentVoucherDto.getTotalValorVentaGravadaIVAP())
                .totalDescuento(paymentVoucherDto.getTotalDescuento())
                .sumatoriaTributosOperacionGratuita(paymentVoucherDto.getTotalImpOperGratuita())
                .sumatoriaIvap(paymentVoucherDto.getTotalIvap())
                .sumatoriaIgv(paymentVoucherDto.getTotalIgv())
                .sumatoriaIsc(paymentVoucherDto.getTotalIsc())
                .sumatoriaOtrostrib(paymentVoucherDto.getTotalOtrostributos())
                .montoDescuentoGlobal(paymentVoucherDto.getDescuentoGlobales())
                .montoSumOtrosCarg(paymentVoucherDto.getSumatoriaOtrosCargos())
                .montoImpTotalVenta(paymentVoucherDto.getImporteTotalVenta())
                .montoTotalAnticipos(paymentVoucherDto.getTotalAnticipos())
                .serieAfectado(paymentVoucherDto.getSerieAfectado())
                .numeroAfectado(paymentVoucherDto.getNumeroAfectado())
                .tipComprobAfectado(paymentVoucherDto.getTipoComprobanteAfectado())
                .motivoNota(paymentVoucherDto.getMotivoNota())
                .codTipNotaCred(paymentVoucherDto.getCodigoTipoNotaCredito())
                .codTipNotaDebit(paymentVoucherDto.getCodigoTipoNotaDebito())
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
                .oficinaId(paymentVoucherDto.getOficinaId())
                .UblVersion(paymentVoucherDto.getUblVersion())
                .build();
    }

    public static PaymentVoucherDto modelToDto(PaymentVoucherModel paymentVoucherModel) {
        if(paymentVoucherModel == null) {
            return null;
        }
        return PaymentVoucherDto.builder()
                .oficinaId(paymentVoucherModel.getOficinaId())
                .idPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher())
                .serie(paymentVoucherModel.getSerie())
                .numero(paymentVoucherModel.getNumero())
                .fechaEmision(paymentVoucherModel.getFechaEmision())
                .fechaEmisionDate(paymentVoucherModel.getFechaEmisionDate())
                .horaEmision(paymentVoucherModel.getHoraEmision())
                .tipoComprobante(paymentVoucherModel.getTipoComprobante())
                .codigoMoneda(paymentVoucherModel.getCodigoMoneda())
                .fechaVencimiento(paymentVoucherModel.getFechaVencimiento())
                .codigoTipoOperacion(paymentVoucherModel.getTipoOperacion())
                .rucEmisor(paymentVoucherModel.getRucEmisor())
                .codigoLocalAnexoEmisor(paymentVoucherModel.getCodigoLocalAnexo())
                .tipoDocumentoReceptor(paymentVoucherModel.getTipDocIdentReceptor())
                .numeroDocumentoReceptor(paymentVoucherModel.getNumDocIdentReceptor())
                .denominacionReceptor(paymentVoucherModel.getDenominacionReceptor())
                .direccionReceptor(paymentVoucherModel.getDireccionReceptor())
                .emailReceptor(paymentVoucherModel.getEmailReceptor())
                .codigoTipoOtroDocumentoRelacionado(paymentVoucherModel.getCodigoTipoOtroDocumentoRelacionado())
                .serieNumeroOtroDocumentoRelacionado(paymentVoucherModel.getSerieNumeroOtroDocumentoRelacionado())
                .totalValorVentaExportacion(paymentVoucherModel.getTotalOperExportada())
                .totalValorVentaGravada(paymentVoucherModel.getTotalOperGravada())
                .totalValorVentaInafecta(paymentVoucherModel.getTotalOperInafecta())
                .totalValorVentaExonerada(paymentVoucherModel.getTotalOperExonerada())
                .totalValorVentaGratuita(paymentVoucherModel.getTotalOperGratuita())
                .totalValorBaseIsc(paymentVoucherModel.getTotalValorBaseIsc())
                .totalValorBaseOtrosTributos(paymentVoucherModel.getTotalValorBaseOtrosTributos())
                .totalValorVentaGravadaIVAP(paymentVoucherModel.getTotalValorVentaGravadaIVAP())
                .totalDescuento(paymentVoucherModel.getTotalDescuento())
                .totalImpOperGratuita(paymentVoucherModel.getSumatoriaTributosOperacionGratuita())
                .totalIvap(paymentVoucherModel.getSumatoriaIvap())
                .totalIgv(paymentVoucherModel.getSumatoriaIgv())
                .totalIsc(paymentVoucherModel.getSumatoriaIsc())
                .totalOtrostributos(paymentVoucherModel.getSumatoriaOtrostrib())
                .descuentoGlobales(paymentVoucherModel.getMontoDescuentoGlobal())
                .sumatoriaOtrosCargos(paymentVoucherModel.getMontoSumOtrosCarg())
                .importeTotalVenta(paymentVoucherModel.getMontoImpTotalVenta())
                .totalAnticipos(paymentVoucherModel.getMontoTotalAnticipos())
                .serieAfectado(paymentVoucherModel.getSerieAfectado())
                .numeroAfectado(paymentVoucherModel.getNumeroAfectado())
                .tipoComprobanteAfectado(paymentVoucherModel.getTipComprobAfectado())
                .motivoNota(paymentVoucherModel.getMotivoNota())
                .codigoTipoNotaCredito(paymentVoucherModel.getCodTipNotaCred())
                .codigoTipoNotaDebito(paymentVoucherModel.getCodTipNotaDebit())
                .identificadorDocumento(paymentVoucherModel.getIdentificadorDocumento())
                .estadoItem(paymentVoucherModel.getEstadoItem())
                .estadoSunat(paymentVoucherModel.getEstadoSunat())
                .estado(paymentVoucherModel.getEstado())
                .estadoAnterior(paymentVoucherModel.getEstadoAnterior())
                .mensajeRespuesta(paymentVoucherModel.getMensajeRespuesta())
                .fechaRegistro(paymentVoucherModel.getFechaRegistro())
                .fechaModificacion(paymentVoucherModel.getFechaModificacion())
                .userName(paymentVoucherModel.getUserName())
                .userNameModificacion(paymentVoucherModel.getUserNameModify())
                .Uuid(paymentVoucherModel.getUuid())
                .ordenCompra(paymentVoucherModel.getOrdenCompra())
                .codigoHash(paymentVoucherModel.getCodigoHash())
                .codigoMedioPago(paymentVoucherModel.getCodigoMedioPago())
                .cuentaFinancieraBeneficiario(paymentVoucherModel.getCuentaFinancieraBeneficiario())
                .codigoBienDetraccion(paymentVoucherModel.getCodigoBienDetraccion())
                .porcentajeDetraccion(paymentVoucherModel.getPorcentajeDetraccion())
                .porcentajeRetencion(paymentVoucherModel.getPorcentajeRetencion())
                .montoDetraccion(paymentVoucherModel.getMontoDetraccion())
                .montoRetencion(paymentVoucherModel.getMontoRetencion())
                .detraccion(paymentVoucherModel.getDetraccion())
                .retencion(paymentVoucherModel.getRetencion())
                .tipoTransaccion(paymentVoucherModel.getTipoTransaccion())
                .montoPendiente(paymentVoucherModel.getMontoPendiente())
                .cantidadCuotas(paymentVoucherModel.getCantidadCuotas())
                .pagoCuenta(paymentVoucherModel.getPagoCuenta())
                .ublVersion(paymentVoucherModel.getUblVersion())
                .build();
    }

    public static List<PaymentVoucherDto> modelListToDtoList(List<PaymentVoucherModel> paymentVoucherModels) {
        if(paymentVoucherModels != null && !paymentVoucherModels.isEmpty()) {
            List<PaymentVoucherDto> paymentVoucherDtos = new ArrayList<>();
            for (PaymentVoucherModel paymentVoucherModel : paymentVoucherModels) {
                paymentVoucherDtos.add(PaymentVoucherConverter.modelToDto(paymentVoucherModel));
            }
            return paymentVoucherDtos;
        } else return null;
    }
}
