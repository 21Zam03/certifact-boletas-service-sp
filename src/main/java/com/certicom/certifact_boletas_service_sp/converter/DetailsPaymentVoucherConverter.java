package com.certicom.certifact_boletas_service_sp.converter;

import com.certicom.certifact_boletas_service_sp.model.DetailsPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.DetailsPaymentVoucherDto;

import java.util.ArrayList;
import java.util.List;

public class DetailsPaymentVoucherConverter {

    public static DetailsPaymentVoucherModel dtoToModel(DetailsPaymentVoucherDto detailsPaymentVoucherDto) {
        return DetailsPaymentVoucherModel.builder()
                .idPaymentVoucher(detailsPaymentVoucherDto.getIdPaymentVoucher())
                .idComprobanteDetalle(detailsPaymentVoucherDto.getIdComprobanteDetalle())
                .numeroItem(detailsPaymentVoucherDto.getNumeroItem())
                .codigoUnidadMedida(detailsPaymentVoucherDto.getCodigoUnidadMedida())
                .cantidad(detailsPaymentVoucherDto.getCantidad())
                .descripcion(detailsPaymentVoucherDto.getDescripcion())
                .codigoProducto(detailsPaymentVoucherDto.getCodigoProducto())
                .codigoProductoGS1(detailsPaymentVoucherDto.getCodigoProductoGS1())
                .valorUnitario(detailsPaymentVoucherDto.getValorUnitario())
                .valorVenta(detailsPaymentVoucherDto.getValorVenta())
                .descuento(detailsPaymentVoucherDto.getDescuento())
                .codigoDescuento(detailsPaymentVoucherDto.getCodigoDescuento())
                .precioVentaUnitario(detailsPaymentVoucherDto.getPrecioVentaUnitario())
                .valorReferencialUnitario(detailsPaymentVoucherDto.getValorReferencialUnitario())
                .montoBaseIgv(detailsPaymentVoucherDto.getMontoBaseIgv())
                .montoBaseIvap(detailsPaymentVoucherDto.getMontoBaseIvap())
                .montoBaseExportacion(detailsPaymentVoucherDto.getMontoBaseExportacion())
                .montoBaseExonerado(detailsPaymentVoucherDto.getMontoBaseExonerado())
                .montoBaseInafecto(detailsPaymentVoucherDto.getMontoBaseInafecto())
                .montoBaseGratuito(detailsPaymentVoucherDto.getMontoBaseGratuito())
                .montoBaseIsc(detailsPaymentVoucherDto.getMontoBaseIsc())
                .montoBaseOtrosTributos(detailsPaymentVoucherDto.getMontoBaseOtrosTributos())
                .igv(detailsPaymentVoucherDto.getIgv())
                .isc(detailsPaymentVoucherDto.getIsc())
                .montoIcbper(detailsPaymentVoucherDto.getMontoIcbper())
                .ivap(detailsPaymentVoucherDto.getIvap())
                .impuestoVentaGratuita(detailsPaymentVoucherDto.getImpuestoVentaGratuita())
                .otrosTributos(detailsPaymentVoucherDto.getOtrosTributos())
                .porcentajeIgv(detailsPaymentVoucherDto.getPorcentajeIgv())
                .porcentajeIvap(detailsPaymentVoucherDto.getPorcentajeIvap())
                .porcentajeIsc(detailsPaymentVoucherDto.getPorcentajeIsc())
                .porcentajeOtrosTributos(detailsPaymentVoucherDto.getPorcentajeOtrosTributos())
                .porcentajeTributoVentaGratuita(detailsPaymentVoucherDto.getPorcentajeTributoVentaGratuita())
                .codigoTipoAfectacionIGV(detailsPaymentVoucherDto.getCodigoTipoAfectacionIGV())
                .codigoTipoCalculoISC(detailsPaymentVoucherDto.getCodigoTipoCalculoISC())
                .productoId(detailsPaymentVoucherDto.getProductoId())
                .detalleViajeDetraccion(detailsPaymentVoucherDto.getDetalleViajeDetraccion())
                .ubigeoOrigenDetraccion(detailsPaymentVoucherDto.getUbigeoOrigenDetraccion())
                .direccionOrigenDetraccion(detailsPaymentVoucherDto.getDireccionOrigenDetraccion())
                .ubigeoDestinoDetraccion(detailsPaymentVoucherDto.getUbigeoDestinoDetraccion())
                .direccionDestinoDetraccion(detailsPaymentVoucherDto.getDireccionDestinoDetraccion())
                .valorServicioTransporte(detailsPaymentVoucherDto.getValorServicioTransporte())
                .valorCargaEfectiva(detailsPaymentVoucherDto.getValorCargaEfectiva())
                .valorCargaUtil(detailsPaymentVoucherDto.getValorCargaUtil())
                .hidroMatricula(detailsPaymentVoucherDto.getHidroMatricula())
                .hidroEmbarcacion(detailsPaymentVoucherDto.getHidroEmbarcacion())
                .hidroDescripcionTipo(detailsPaymentVoucherDto.getHidroDescripcionTipo())
                .hidroLugarDescarga(detailsPaymentVoucherDto.getHidroLugarDescarga())
                .hidroFechaDescarga(detailsPaymentVoucherDto.getHidroFechaDescarga())
                .hidroCantidad(detailsPaymentVoucherDto.getHidroCantidad())
                .unidadManejo(detailsPaymentVoucherDto.getUnidadManejo())
                .instruccionesEspeciales(detailsPaymentVoucherDto.getInstruccionesEspeciales())
                .marca(detailsPaymentVoucherDto.getMarca())
                .adicional(detailsPaymentVoucherDto.getAdicional())
                .estado(detailsPaymentVoucherDto.getEstado())
                .build();
    }

    public static List<DetailsPaymentVoucherModel> detoListToModelList(List<DetailsPaymentVoucherDto> detailsPaymentVoucherDtoList) {
        if(detailsPaymentVoucherDtoList!=null && !detailsPaymentVoucherDtoList.isEmpty()){
            List<DetailsPaymentVoucherModel> detailsPaymentVoucherModelList = new ArrayList<>();
            for (DetailsPaymentVoucherDto item : detailsPaymentVoucherDtoList) {
                detailsPaymentVoucherModelList.add(dtoToModel(item));
            }
            return detailsPaymentVoucherModelList;
        } else return null;
    }
}
