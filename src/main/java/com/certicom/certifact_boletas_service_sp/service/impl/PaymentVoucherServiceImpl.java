package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.*;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.*;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherService;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherServiceImpl implements PaymentVoucherService {

    private final PaymentVoucherMapper paymentVoucherMapper;
    private final PaymentVoucherFileMapper paymentVoucherFileMapper;
    private final AnticipoPaymentVoucherMapper anticipoPaymentVoucherMapper;
    private final TypeFieldMapper typeFieldMapper;
    private final AditionalFieldPaymentVoucherMapper aditionalFieldPaymentVoucherMapper;
    private final PaymentCuotasMapper paymentCuotasMapper;
    private final DetailsPaymentVoucherMapper detailsPaymentVoucherMapper;
    private final GuiaPaymentVoucherMapper guiaPaymentVoucherMapper;

    @Override
    @Transactional
    public PaymentVoucherDto savePaymentVoucher(PaymentVoucherDto paymentVoucherDto) {
        log.debug("Guardando paymentvoucher con datos completos: {}", paymentVoucherDto);
        PaymentVoucherDto model = null;
        int result = 0;
        try {
            PaymentVoucherModel paymentVoucher = PaymentVoucherConverter.dtoToModel(paymentVoucherDto);
            if(paymentVoucher.getIdPaymentVoucher()==null) {
                result = paymentVoucherMapper.insert(paymentVoucher);
            } else {
                result = paymentVoucherMapper.update(paymentVoucher);
            }
            if(result == 0) {
                throw new RuntimeException("No se pudo registrar el comprobante");
            }
            if(paymentVoucherDto.getPaymentVoucherFileModelList()!=null && !paymentVoucherDto.getPaymentVoucherFileModelList().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getPaymentVoucherFileModelList().size(); i++) {
                    paymentVoucherDto.getPaymentVoucherFileModelList().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    System.out.println("LISTA: "+paymentVoucherDto.getPaymentVoucherFileModelList());
                    System.out.println("ID: "+paymentVoucher.getIdPaymentVoucher());
                    result = paymentVoucherFileMapper.save(PaymentVoucherFileConverter.dtoToModel(paymentVoucherDto.getPaymentVoucherFileModelList().get(i)));
                    if(result == 0) {
                        throw new RuntimeException("No se pudo registrar el comprobante archivo");
                    }
                }
            }
            if(paymentVoucherDto.getAnticipos() != null && !paymentVoucherDto.getAnticipos().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getAnticipos().size(); i++) {
                    paymentVoucherDto.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = anticipoPaymentVoucherMapper.save(AnticipoPaymentVoucherConverter.requestToModel(paymentVoucherDto.getAnticipos().get(i)));
                    if(result == 0) {
                        throw new RuntimeException("No se pudo registrar el comprobante archivo");
                    }
                }
            }
            if(paymentVoucherDto.getCamposAdicionales()!= null && !paymentVoucherDto.getCamposAdicionales().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getCamposAdicionales().size(); i++) {
                    paymentVoucherDto.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    System.out.println("NAME TEST: "+paymentVoucherDto.getCamposAdicionales().get(i).getNombreCampo());
                    Integer id = typeFieldMapper.getIdByName(paymentVoucherDto.getCamposAdicionales().get(i).getNombreCampo());
                    paymentVoucherDto.getCamposAdicionales().get(i).setTypeFieldId(id);
                    result = aditionalFieldPaymentVoucherMapper.save(AditionalFIeldPaymentVoucherConverter.requestToModel(paymentVoucherDto.getCamposAdicionales().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar el campo adicional");
                    }
                }
            }
            if (paymentVoucherDto.getCuotas() != null && !paymentVoucherDto.getCuotas().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getCuotas().size(); i++) {
                    paymentVoucherDto.getCuotas().get(i).setIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
                    result = paymentCuotasMapper.save(PaymentCuotasConverter.requestToModel(paymentVoucherDto.getCuotas().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar la cuota");
                    }
                }
            }
            if(paymentVoucherDto.getItems() != null && !paymentVoucherDto.getItems().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getItems().size(); i++) {
                    System.out.println("ID paymente voucher: "+paymentVoucher.getIdPaymentVoucher());
                    paymentVoucherDto.getItems().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = detailsPaymentVoucherMapper.save(DetailsPaymentVoucherConverter.requestToModel(paymentVoucherDto.getItems().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar los items");
                    }
                }
            }
            if(paymentVoucherDto.getGuiasRelacionadas() != null && !paymentVoucherDto.getGuiasRelacionadas().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getGuiasRelacionadas().size(); i++) {
                    paymentVoucherDto.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = guiaPaymentVoucherMapper.save(GuiaPaymentVoucherConverter.requestToModel(paymentVoucherDto.getGuiasRelacionadas().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar la guia relacionada");
                    }
                }
            }
            PaymentVoucherModel payment = paymentVoucherMapper.findById(paymentVoucher.getIdPaymentVoucher());
            model = PaymentVoucherConverter.modelToDto(payment);
            if(model==null) {
                throw new RuntimeException("No se pudo obtener el registro de payment");
            }
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return model;
    }

    @Transactional
    @Override
    public PaymentVoucherDto updatePaymentVoucher(PaymentVoucherDto paymentVoucherDto) {
        log.debug("Iniciando proceso de actualizacion : {}", paymentVoucherDto);
        PaymentVoucherDto model = null;
        int result = 0;
        try {
            PaymentVoucherModel paymentVoucherModel = PaymentVoucherConverter.dtoToModel(paymentVoucherDto);
            result = paymentVoucherMapper.update(paymentVoucherModel);
            validateUpdateResult(result, LogMessages.PAYMENT_VOUCHER_NOT_UPDATE, paymentVoucherModel.getIdPaymentVoucher());
            if(paymentVoucherDto.getPaymentVoucherFileModelList()!=null && !paymentVoucherDto.getPaymentVoucherFileModelList().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getPaymentVoucherFileModelList().size(); i++) {
                    paymentVoucherDto.getPaymentVoucherFileModelList().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                    result = paymentVoucherFileMapper.update(PaymentVoucherFileConverter.dtoToModel(paymentVoucherDto.getPaymentVoucherFileModelList().get(i)));
                    validateUpdateResult(result, LogMessages.PAYMENT_VOUCHER_FILE_NOT_UPDATE, paymentVoucherModel.getIdPaymentVoucher());
                }
            }
            if(paymentVoucherDto.getAnticipos() != null && !paymentVoucherDto.getAnticipos().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getAnticipos().size(); i++) {
                    paymentVoucherDto.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                    result = anticipoPaymentVoucherMapper.update(AnticipoPaymentVoucherConverter.requestToModel(paymentVoucherDto.getAnticipos().get(i)));
                    validateUpdateResult(result, LogMessages.ANTICIPO_PAYMENT_VOUCHER_NOT_UPDATE, paymentVoucherDto.getAnticipos().get(i).getIdAnticipoPayment());
                }
            }
            if(paymentVoucherDto.getCamposAdicionales()!= null && !paymentVoucherDto.getCamposAdicionales().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getCamposAdicionales().size(); i++) {
                    paymentVoucherDto.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                    Integer id = typeFieldMapper.getIdByName(paymentVoucherDto.getCamposAdicionales().get(i).getNombreCampo());
                    paymentVoucherDto.getCamposAdicionales().get(i).setTypeFieldId(id);
                    result = aditionalFieldPaymentVoucherMapper.update(AditionalFIeldPaymentVoucherConverter.requestToModel(paymentVoucherDto.getCamposAdicionales().get(i)));
                    validateUpdateResult(result, LogMessages.ADITIONAL_FIELD_PAYMENT_VOUCHER_NOT_UPDATE, paymentVoucherDto.getCamposAdicionales().get(i).getId());
                }
            }
            if (paymentVoucherDto.getCuotas() != null && !paymentVoucherDto.getCuotas().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getCuotas().size(); i++) {
                    paymentVoucherDto.getCuotas().get(i).setIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
                    result = paymentCuotasMapper.update(PaymentCuotasConverter.requestToModel(paymentVoucherDto.getCuotas().get(i)));
                    validateUpdateResult(result, LogMessages.PAYMENT_CUOTAS_NOT_UPDATE, paymentVoucherDto.getCuotas().get(i).getIdCuotas());
                }
            }
            if(paymentVoucherDto.getItems() != null && !paymentVoucherDto.getItems().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getItems().size(); i++) {
                    paymentVoucherDto.getItems().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                    result = detailsPaymentVoucherMapper.update(DetailsPaymentVoucherConverter.requestToModel(paymentVoucherDto.getItems().get(i)));
                    validateUpdateResult(result, LogMessages.DETAILS_PAYMENT_VOUCHER_NOT_UPDATE, paymentVoucherDto.getItems().get(i).getIdPaymentVoucher());
                }
            }
            if(paymentVoucherDto.getGuiasRelacionadas() != null && !paymentVoucherDto.getGuiasRelacionadas().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getGuiasRelacionadas().size(); i++) {
                    paymentVoucherDto.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
                    result = guiaPaymentVoucherMapper.update(GuiaPaymentVoucherConverter.requestToModel(paymentVoucherDto.getGuiasRelacionadas().get(i)));
                    validateUpdateResult(result, LogMessages.GUIA_PAYMENT_VOUCHER_NOT_UPDATE, paymentVoucherDto.getGuiasRelacionadas().get(i).getIdPaymentVoucher());
                }
            }
            PaymentVoucherModel payment = paymentVoucherMapper.findById(paymentVoucherModel.getIdPaymentVoucher());
            if(payment == null) {
                throw new ServiceException("");
            }
            model = PaymentVoucherConverter.modelToDto(payment);
        } catch (Exception e) {
            log.error(LogMessages.PROCESS_FAILED_LOG, e.getMessage());
            throw new ServiceException(LogMessages.PROCESS_FAILED_EXCEPTION+ e.getMessage());
        }
        log.info(LogMessages.PAYMENT_VOUCHER_UPDATED, model.getIdentificadorDocumento());
        return model;
    }

    @Override
    public int save(PaymentVoucherDto paymentVoucherDto) {
        return 0;
    }

    @Override
    public int update(PaymentVoucherDto paymentVoucherDto) {
        int result = 0;
        try {
            result = paymentVoucherMapper.update(PaymentVoucherConverter.dtoToModel(paymentVoucherDto));
            validateUpdateResult(result, LogMessages.PAYMENT_VOUCHER_NOT_UPDATE, paymentVoucherDto.getIdPaymentVoucher());
        } catch (Exception e) {
            log.error(LogMessages.ERROR_EXCEPTION, e.getMessage());
        }
        return result;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento) {
        PaymentVoucherDto paymentVoucherDto = null;
        try {
            System.out.println("IDENTIFICADOR: "+identificadorDocumento);
            PaymentVoucherModel paymentVoucherModel = paymentVoucherMapper.findByIdentificadorDocumento(identificadorDocumento);
            System.out.println("MODEL: "+ paymentVoucherModel);
            if(paymentVoucherModel!=null) {
                paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);
                System.out.println("PAYNMENTVOUCHER DTO: "+paymentVoucherDto);
            }
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return paymentVoucherDto;
    }

    @Override
    public Integer getNumeracion(String tipoComprobante, String serie, String ruc) {
        return paymentVoucherMapper.getNumeroByTipoComprobanteAndSerieAndRucEmisor(tipoComprobante, serie, ruc);
    }

    @Override
    public List<PaymentVoucherDto> findListSpecificForSummary(String ruc, String fechaEmision, String tipo, String serie, Integer numero) {
        List<PaymentVoucherDto> listSummaryDto = null;
        try {
            List<PaymentVoucherModel> listSummary = paymentVoucherMapper.findListSpecificForSummary(ruc, fechaEmision, tipo, serie, numero);
            System.out.println("LIST SUMMARY: "+listSummary);
            listSummaryDto = PaymentVoucherConverter.modelListToDtoList(listSummary);
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return listSummaryDto;
    }

    @Override
    public List<PaymentVoucherDto> findAllForSummaryByRucEmisorAndFechaEmision(String rucEmisor, String fechaEmision) {
        List<PaymentVoucherDto> listSummaryDto = null;
        try {
            List<PaymentVoucherModel> listSummary = paymentVoucherMapper.findAllForSummaryByRucEmisorAndFechaEmision(rucEmisor, fechaEmision);
            listSummaryDto = PaymentVoucherConverter.modelListToDtoList(listSummary);
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return listSummaryDto;
    }

    @Override
    @Transactional
    public int updateStateToSendSunatForSummaryDocuments(List<Long> ids, String usuario, Timestamp fechaModificacion) {
        int result = 0;
        try {
            result = paymentVoucherMapper.updateStateToSendSunatForSummaryDocuments(ids, usuario, fechaModificacion);
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return result;
    }

    @Override
    public int updateComprobantesBySummaryDocuments(List<String> identificadorComprobantes, String estado, String estadoSunat, String usuario, Timestamp fechaModificacion) {
        return paymentVoucherMapper.updateComprobantesBySummaryDocuments(identificadorComprobantes, estado, estadoSunat, usuario, fechaModificacion);
    }

    @Override
    public int updateComprobantesOnResumenError(List<String> identificadoresComprobantes, String usuario, Timestamp fechaModificacion) {
        return paymentVoucherMapper.updateComprobantesOnResumenError(identificadoresComprobantes, usuario, fechaModificacion)   ;
    }

    @Override
    public PaymentVoucherDto findByRucAndTipoAndSerieAndNumero(String finalRucEmisor, String tipoComprobante, String serie, Integer numero) {
        PaymentVoucherDto paymentVoucherDto = null;
        try {
            PaymentVoucherModel paymentVoucherModel = paymentVoucherMapper.findByRucAndTipoAndSerieAndNumero(finalRucEmisor, tipoComprobante, serie, numero);
            paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return paymentVoucherDto;
    }

    private void watchErrorLogs(Exception e) {
        log.error("ERROR: {}", e.getMessage());
    }

    private void validateUpdateResult(int result, String message, Object id) {
        if(result == 0) {
            log.warn(message, id);
            throw new ServiceException(message);
        }
    }

}
