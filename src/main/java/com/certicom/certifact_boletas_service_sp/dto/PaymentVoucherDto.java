package com.certicom.certifact_boletas_service_sp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaymentVoucherDto {

    private Long idPaymentVoucher;

    private String tipoComprobante;
    private String serie;
    private Integer numero;
    private String fechaEmision;
    private String horaEmision;
    private String fechaVencimiento;
    private String codigoMoneda;
    @JsonProperty("tipoOperacion")
    private String codigoTipoOperacion;
    private String codigoTipoOperacionCatalogo51;
    private String rucEmisor;
    private String direccionOficinaEmisor;
    @JsonProperty("codigoLocalAnexo")
    private String codigoLocalAnexoEmisor;
    @JsonProperty("tipoDocIdentReceptor")
    private String tipoDocumentoReceptor;
    @JsonProperty("numDocIdentReceptor")
    private String numeroDocumentoReceptor;
    private String denominacionReceptor;
    private String direccionReceptor;
    private String emailReceptor;
    private List<GuiaPaymentVoucherDto> guiasRelacionadas;
    private List<DocumentoRelacionadoRequest> documentosRelacionados;
    private List<LeyendaRequest> leyendas;
    private String serieNumeroOtroDocumentoRelacionado;
    private String codigoTipoOtroDocumentoRelacionado;
    @JsonProperty("totalValorVentaOperacionExportada")
    private BigDecimal totalValorVentaExportacion;
    @JsonProperty("totalValorVentaOperacionGravada")
    private BigDecimal totalValorVentaGravada;
    private BigDecimal totalValorVentaGravadaIVAP;
    @JsonProperty("totalValorVentaOperacionInafecta")
    private BigDecimal totalValorVentaInafecta;
    @JsonProperty("totalValorVentaOperacionExonerada")
    private BigDecimal totalValorVentaExonerada;
    @JsonProperty("totalValorVentaOperacionGratuita")
    private BigDecimal totalValorVentaGratuita;
    private BigDecimal totalValorBaseOtrosTributos;
    private BigDecimal totalValorBaseIsc;
    private BigDecimal totalIgv;
    private BigDecimal totalIvap;
    private BigDecimal totalIsc;
    private BigDecimal totalImpOperGratuita;
    private BigDecimal totalOtrostributos;
    private BigDecimal totalDescuento;
    private BigDecimal descuentoGlobales;
    private BigDecimal sumatoriaOtrosCargos;
    @JsonProperty("montoTotalAnticipos")
    private BigDecimal totalAnticipos;
    private BigDecimal importeTotalVenta;
    private String serieAfectado;
    private Integer numeroAfectado;
    private String tipoComprobanteAfectado;
    private String codigoTipoNotaCredito;
    private String codigoTipoNotaDebito;
    private String motivoNota;
    @JsonProperty("detailsPaymentVouchers")
    private List<DetailsPaymentVoucherDto> items;
    private String denominacionEmisor;
    private String nombreComercialEmisor;
    private String tipoDocumentoEmisor;
    private String identificadorDocumento;
    private String ordenCompra;
    private List<AnticipoPaymentVoucherDto> anticipos;
    private List<AditionalFieldPaymentVoucherDto> camposAdicionales;
    private List<PaymentCuotasDto> cuotas;
    private String codigoBienDetraccion;
    private BigDecimal porcentajeDetraccion;
    private BigDecimal porcentajeRetencion;
    private String cuentaFinancieraBeneficiario;
    private String codigoMedioPago;
    private BigDecimal montoDetraccion;
    private BigDecimal montoRetencion;
    private String detraccion;
    private String ublVersion;
    private String codigoHash;
    private Integer oficinaId;
    private Integer retencion;
    private BigDecimal tipoTransaccion;
    private BigDecimal montoPendiente;
    private BigDecimal cantidadCuotas;
    private BigDecimal pagoCuenta;

    private String idpay;

    private String estado;
    private String estadoAnterior;
    private Integer estadoItem;
    private String estadoSunat;
    private String mensajeRespuesta;
    private Timestamp fechaRegistro;
    private String userName;
    private Timestamp fechaModificacion;

    @JsonProperty("userNameModify")
    private String userNameModificacion;
    private String Uuid;
    private Date fechaEmisionDate;

    private BranchOfficeRequest branchOffice;
    private List<PaymentVoucherFileDto> paymentVoucherFileDtoList;

}
