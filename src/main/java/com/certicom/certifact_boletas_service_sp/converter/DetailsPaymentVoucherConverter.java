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

    public static DetailsPaymentVoucherDto modelToDto(DetailsPaymentVoucherModel detailsPaymentVoucherModel) {
        if(detailsPaymentVoucherModel != null) {
            return DetailsPaymentVoucherDto.builder()
                    .idPaymentVoucher(detailsPaymentVoucherModel.getIdPaymentVoucher())
                    .idComprobanteDetalle(detailsPaymentVoucherModel.getIdComprobanteDetalle())
                    .numeroItem(detailsPaymentVoucherModel.getNumeroItem())
                    .codigoUnidadMedida(detailsPaymentVoucherModel.getCodigoUnidadMedida())
                    .cantidad(detailsPaymentVoucherModel.getCantidad())
                    .descripcion(detailsPaymentVoucherModel.getDescripcion())
                    .codigoProducto(detailsPaymentVoucherModel.getCodigoProducto())
                    .codigoProductoGS1(detailsPaymentVoucherModel.getCodigoProductoGS1())
                    .valorUnitario(detailsPaymentVoucherModel.getValorUnitario())
                    .valorVenta(detailsPaymentVoucherModel.getValorVenta())
                    .descuento(detailsPaymentVoucherModel.getDescuento())
                    .codigoDescuento(detailsPaymentVoucherModel.getCodigoDescuento())
                    .precioVentaUnitario(detailsPaymentVoucherModel.getPrecioVentaUnitario())
                    .valorReferencialUnitario(detailsPaymentVoucherModel.getValorReferencialUnitario())
                    .montoBaseIgv(detailsPaymentVoucherModel.getMontoBaseIgv())
                    .montoBaseIvap(detailsPaymentVoucherModel.getMontoBaseIvap())
                    .montoBaseExportacion(detailsPaymentVoucherModel.getMontoBaseExportacion())
                    .montoBaseExonerado(detailsPaymentVoucherModel.getMontoBaseExonerado())
                    .montoBaseInafecto(detailsPaymentVoucherModel.getMontoBaseInafecto())
                    .montoBaseGratuito(detailsPaymentVoucherModel.getMontoBaseGratuito())
                    .montoBaseIsc(detailsPaymentVoucherModel.getMontoBaseIsc())
                    .montoBaseOtrosTributos(detailsPaymentVoucherModel.getMontoBaseOtrosTributos())
                    .igv(detailsPaymentVoucherModel.getIgv())
                    .isc(detailsPaymentVoucherModel.getIsc())
                    .montoIcbper(detailsPaymentVoucherModel.getMontoIcbper())
                    .ivap(detailsPaymentVoucherModel.getIvap())
                    .impuestoVentaGratuita(detailsPaymentVoucherModel.getImpuestoVentaGratuita())
                    .otrosTributos(detailsPaymentVoucherModel.getOtrosTributos())
                    .porcentajeIgv(detailsPaymentVoucherModel.getPorcentajeIgv())
                    .porcentajeIvap(detailsPaymentVoucherModel.getPorcentajeIvap())
                    .porcentajeIsc(detailsPaymentVoucherModel.getPorcentajeIsc())
                    .porcentajeOtrosTributos(detailsPaymentVoucherModel.getPorcentajeOtrosTributos())
                    .porcentajeTributoVentaGratuita(detailsPaymentVoucherModel.getPorcentajeTributoVentaGratuita())
                    .codigoTipoAfectacionIGV(detailsPaymentVoucherModel.getCodigoTipoAfectacionIGV())
                    .codigoTipoCalculoISC(detailsPaymentVoucherModel.getCodigoTipoCalculoISC())
                    .productoId(detailsPaymentVoucherModel.getProductoId())
                    .detalleViajeDetraccion(detailsPaymentVoucherModel.getDetalleViajeDetraccion())
                    .ubigeoOrigenDetraccion(detailsPaymentVoucherModel.getUbigeoOrigenDetraccion())
                    .direccionOrigenDetraccion(detailsPaymentVoucherModel.getDireccionOrigenDetraccion())
                    .ubigeoDestinoDetraccion(detailsPaymentVoucherModel.getUbigeoDestinoDetraccion())
                    .direccionDestinoDetraccion(detailsPaymentVoucherModel.getDireccionDestinoDetraccion())
                    .valorServicioTransporte(detailsPaymentVoucherModel.getValorServicioTransporte())
                    .valorCargaEfectiva(detailsPaymentVoucherModel.getValorCargaEfectiva())
                    .valorCargaUtil(detailsPaymentVoucherModel.getValorCargaUtil())
                    .hidroMatricula(detailsPaymentVoucherModel.getHidroMatricula())
                    .hidroEmbarcacion(detailsPaymentVoucherModel.getHidroEmbarcacion())
                    .hidroDescripcionTipo(detailsPaymentVoucherModel.getHidroDescripcionTipo())
                    .hidroLugarDescarga(detailsPaymentVoucherModel.getHidroLugarDescarga())
                    .hidroFechaDescarga(detailsPaymentVoucherModel.getHidroFechaDescarga())
                    .hidroCantidad(detailsPaymentVoucherModel.getHidroCantidad())
                    .unidadManejo(detailsPaymentVoucherModel.getUnidadManejo())
                    .instruccionesEspeciales(detailsPaymentVoucherModel.getInstruccionesEspeciales())
                    .marca(detailsPaymentVoucherModel.getMarca())
                    .adicional(detailsPaymentVoucherModel.getAdicional())
                    .estado(detailsPaymentVoucherModel.getEstado())
                    .build();
        } return null;
    }

    public static List<DetailsPaymentVoucherModel> dtoListToModelList(List<DetailsPaymentVoucherDto> detailsPaymentVoucherDtoList) {
        if(detailsPaymentVoucherDtoList!=null && !detailsPaymentVoucherDtoList.isEmpty()){
            List<DetailsPaymentVoucherModel> detailsPaymentVoucherModelList = new ArrayList<>();
            for (DetailsPaymentVoucherDto item : detailsPaymentVoucherDtoList) {
                detailsPaymentVoucherModelList.add(dtoToModel(item));
            }
            return detailsPaymentVoucherModelList;
        } else return null;
    }

    public static List<DetailsPaymentVoucherDto> modelListToDtoList(List<DetailsPaymentVoucherModel> detailsPaymentVoucherModelList) {
        if(detailsPaymentVoucherModelList == null || !detailsPaymentVoucherModelList.isEmpty()) {
            List<DetailsPaymentVoucherDto> detailsPaymentVoucherDtoList = new ArrayList<>();
            for (DetailsPaymentVoucherModel detailsPaymentVoucherModel : detailsPaymentVoucherModelList) {
                DetailsPaymentVoucherDto detailsPaymentVoucherDto = modelToDto(detailsPaymentVoucherModel);
                detailsPaymentVoucherDtoList.add(detailsPaymentVoucherDto);
            }
            return detailsPaymentVoucherDtoList;
        } return null;
    }
}
