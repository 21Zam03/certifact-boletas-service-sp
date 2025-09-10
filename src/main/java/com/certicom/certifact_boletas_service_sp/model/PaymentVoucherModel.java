package com.certicom.certifact_boletas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentVoucherModel {

    private Long idPaymentVoucher;
    private String serie;
    private Integer numero;
    private String fechaEmision;
    private Date fechaEmisionDate;
    private String horaEmision;
    private String tipoComprobante;
    private String codigoMoneda;
    private String fechaVencimiento;
    private String tipoOperacion;
    private String rucEmisor;
    private String codigoLocalAnexo;
    private String tipoDocIdenReceptor;
    private String numDocIdenReceptor;
    private String denominacionReceptor;
    private String direccionReceptor;
    private String emailReceptor;
    private String codigoTipoDocumentoRelacionado;
    private String serieNumeroDocumentoRelacionado;
    private BigDecimal totalValorVentaOperacionExportada;
    private BigDecimal totalValorVentaOperacionGravada;
    private BigDecimal totalValorVentaOperacionInafecta;
    private BigDecimal totalValorVentaOperacionExonerada;
    private BigDecimal totalValorVentaOperacionGratuita;
    private BigDecimal totalValorBaseIsc;
    private BigDecimal totalValorBaseOtrosTributos;
    private BigDecimal totalValorVentaGravadaIVAP;
    private BigDecimal totalDescuento;

    private BigDecimal sumatoriaTributosOperacionGratuita;
    private BigDecimal sumatoriaIvap;
    private BigDecimal sumatoriaIgv;
    private BigDecimal sumatoriaIsc;
    private BigDecimal sumatoriaOtrostributos;
    private BigDecimal montoDescuentoGlobal;
    private BigDecimal montoSumatorioOtrosCargos;
    private BigDecimal montoImporteTotalVenta;
    private BigDecimal montoTotalAnticipos;
    private String serieAfectado;
    private Integer numeroAfectado;
    private String tipoComprobanteAfectado;
    private String motivoNota;
    private String codigoTipoNotaCredito;
    private String codigoTipoNotaDebito;
    private String identificadorDocumento;
    private Integer estadoItem;
    private String estadoSunat;
    private String estado;
    private String estadoAnterior;
    private String mensajeRespuesta;
    private Timestamp fechaRegistro;
    private Timestamp fechaModificacion;
    private String userName;
    private String userNameModify;
    private String Uuid;
    private String ordenCompra;
    private String codigoRespuestaSunat;
    private String UblVersion;
    private String codigoHash;
    private String codigoMedioPago;
    private String cuentaFinancieraBeneficiario;
    private String codigoBienDetraccion;
    private BigDecimal porcentajeDetraccion;
    private BigDecimal porcentajeRetencion;
    private BigDecimal montoDetraccion;
    private BigDecimal montoRetencion;
    private String detraccion;
    private Integer retencion;
    private BigDecimal tipoTransaccion;
    private BigDecimal montoPendiente;
    private BigDecimal cantidadCuotas;
    private BigDecimal pagoCuenta;

    private String direccionOficinaEmisor;
    private String serieNumeroOtroDocumentoRelacionado;
    private String codigoTipoOtroDocumentoRelacionado;

    private String denominacionEmisor;
    private String nombreComercialEmisor;
    private String tipoDocumentoEmisor;

    private Integer oficinaId;

}
