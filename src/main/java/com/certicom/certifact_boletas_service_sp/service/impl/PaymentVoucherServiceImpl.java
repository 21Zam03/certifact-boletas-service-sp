package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.*;
import com.certicom.certifact_boletas_service_sp.dto.*;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.*;
import com.certicom.certifact_boletas_service_sp.model.AnticipoPaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;
import com.certicom.certifact_boletas_service_sp.service.*;
import com.certicom.certifact_boletas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PaymentVoucherServiceImpl extends AbstractGenericService<PaymentVoucherModel, Long, PaymentVoucherMapper>
        implements PaymentVoucherService {

    private final PaymentVoucherFileMapper paymentVoucherFileMapper;
    private final AnticipoPaymentVoucherMapper anticipoPaymentVoucherMapper;
    private final TypeFieldMapper typeFieldMapper;
    private final AditionalFieldPaymentVoucherMapper aditionalFieldPaymentVoucherMapper;
    private final PaymentCuotasMapper paymentCuotasMapper;
    private final DetailsPaymentVoucherMapper detailsPaymentVoucherMapper;
    private final GuiaPaymentVoucherMapper guiaPaymentVoucherMapper;
    private final PaymentVoucherFileService paymentVoucherFileService;
    private final AnticipoPaymentVoucherService anticipoPaymentVoucherService;
    private final TypeFieldService typeFieldService;
    private final AditionalFieldPaymentVoucherService aditionalFieldPaymentVoucherService;
    private final PaymentCuotasService paymentCuotasService;
    private final DetailsPaymentVoucherService detailsPaymentVoucherService;
    private final GuiaPaymentVoucherService guiaPaymentVoucherService;

    protected PaymentVoucherServiceImpl(
            PaymentVoucherMapper paymentVoucherMapper,
            PaymentVoucherFileMapper paymentVoucherFileMapper,
            AnticipoPaymentVoucherMapper anticipoPaymentVoucherMapper,
            TypeFieldMapper typeFieldMapper,
            AditionalFieldPaymentVoucherMapper aditionalFieldPaymentVoucherMapper,
            PaymentCuotasMapper paymentCuotasMapper,
            DetailsPaymentVoucherMapper detailsPaymentVoucherMapper,
            GuiaPaymentVoucherMapper guiaPaymentVoucherMapper,
            PaymentVoucherFileService paymentVoucherFileService,
            AnticipoPaymentVoucherService anticipoPaymentVoucherService,
            TypeFieldService typeFieldService,
            AditionalFieldPaymentVoucherService aditionalFieldPaymentVoucherService,
            PaymentCuotasService paymentCuotasService,
            DetailsPaymentVoucherService detailsPaymentVoucherService,
            GuiaPaymentVoucherService guiaPaymentVoucherService
    ) {
        super(paymentVoucherMapper);
        this.paymentVoucherFileMapper = paymentVoucherFileMapper;
        this.anticipoPaymentVoucherMapper = anticipoPaymentVoucherMapper;
        this.typeFieldMapper = typeFieldMapper;
        this.aditionalFieldPaymentVoucherMapper = aditionalFieldPaymentVoucherMapper;
        this.paymentCuotasMapper = paymentCuotasMapper;
        this.detailsPaymentVoucherMapper = detailsPaymentVoucherMapper;
        this.guiaPaymentVoucherMapper = guiaPaymentVoucherMapper;
        this.paymentVoucherFileService = paymentVoucherFileService;
        this.anticipoPaymentVoucherService = anticipoPaymentVoucherService;
        this.typeFieldService = typeFieldService;
        this.aditionalFieldPaymentVoucherService = aditionalFieldPaymentVoucherService;
        this.paymentCuotasService = paymentCuotasService;
        this.detailsPaymentVoucherService = detailsPaymentVoucherService;
        this.guiaPaymentVoucherService = guiaPaymentVoucherService;
    }

    @Override
    @Transactional
    public PaymentVoucherDto savePaymentVoucherProcess(PaymentVoucherDto paymentVoucherDto) {
        log.debug("Guardando paymentvoucher con datos completos: {}", paymentVoucherDto);
        PaymentVoucherDto model = null;
        int result = 0;
        try {
            PaymentVoucherModel paymentVoucher = PaymentVoucherConverter.dtoToModel(paymentVoucherDto);
            if(paymentVoucher.getIdPaymentVoucher()==null) {
                result = mapper.insert(paymentVoucher);
            } else {
                result = mapper.update(paymentVoucher);
            }
            if(result == 0) {
                throw new RuntimeException("No se pudo registrar el comprobante");
            }
            if(paymentVoucherDto.getPaymentVoucherFileModelList()!=null && !paymentVoucherDto.getPaymentVoucherFileModelList().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getPaymentVoucherFileModelList().size(); i++) {
                    paymentVoucherDto.getPaymentVoucherFileModelList().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = paymentVoucherFileMapper.insert(PaymentVoucherFileConverter.dtoToModel(paymentVoucherDto.getPaymentVoucherFileModelList().get(i)));
                    if(result == 0) {
                        throw new RuntimeException("No se pudo registrar el comprobante archivo");
                    }
                }
            }
            if(paymentVoucherDto.getAnticipos() != null && !paymentVoucherDto.getAnticipos().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getAnticipos().size(); i++) {
                    paymentVoucherDto.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = anticipoPaymentVoucherMapper.insert(AnticipoPaymentVoucherConverter.dtoToModel(paymentVoucherDto.getAnticipos().get(i)));
                    if(result == 0) {
                        throw new RuntimeException("No se pudo registrar el comprobante archivo");
                    }
                }
            }
            if(paymentVoucherDto.getCamposAdicionales()!= null && !paymentVoucherDto.getCamposAdicionales().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getCamposAdicionales().size(); i++) {
                    paymentVoucherDto.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    System.out.println("NAME TEST: "+paymentVoucherDto.getCamposAdicionales().get(i).getNombreCampo());
                    Long id = typeFieldMapper.getIdByName(paymentVoucherDto.getCamposAdicionales().get(i).getNombreCampo());
                    paymentVoucherDto.getCamposAdicionales().get(i).setTypeFieldId(id);
                    result = aditionalFieldPaymentVoucherMapper.insert(AditionalFIeldPaymentVoucherConverter.dtoToModel(paymentVoucherDto.getCamposAdicionales().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar el campo adicional");
                    }
                }
            }
            if (paymentVoucherDto.getCuotas() != null && !paymentVoucherDto.getCuotas().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getCuotas().size(); i++) {
                    paymentVoucherDto.getCuotas().get(i).setIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
                    result = paymentCuotasMapper.insert(PaymentCuotasConverter.dtoToModel(paymentVoucherDto.getCuotas().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar la cuota");
                    }
                }
            }
            if(paymentVoucherDto.getItems() != null && !paymentVoucherDto.getItems().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getItems().size(); i++) {
                    System.out.println("ID paymente voucher: "+paymentVoucher.getIdPaymentVoucher());
                    paymentVoucherDto.getItems().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = detailsPaymentVoucherMapper.insert(DetailsPaymentVoucherConverter.dtoToModel(paymentVoucherDto.getItems().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar los items");
                    }
                }
            }
            if(paymentVoucherDto.getGuiasRelacionadas() != null && !paymentVoucherDto.getGuiasRelacionadas().isEmpty()) {
                for (int i = 0; i < paymentVoucherDto.getGuiasRelacionadas().size(); i++) {
                    paymentVoucherDto.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = guiaPaymentVoucherMapper.save(GuiaPaymentVoucherConverter.dtoToModel(paymentVoucherDto.getGuiasRelacionadas().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar la guia relacionada");
                    }
                }
            }
            PaymentVoucherModel payment = mapper.findById(paymentVoucher.getIdPaymentVoucher());
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
    public PaymentVoucherDto updatePaymentVoucherProcess(PaymentVoucherDto paymentVoucherDto) {
        log.debug(LogMessages.PROCESS_START_1, paymentVoucherDto);
        try {
            updatePaymentVoucher(paymentVoucherDto);
            setInfoPaymentFiles(paymentVoucherDto.getPaymentVoucherFileModelList(), paymentVoucherDto.getIdPaymentVoucher());
            setInfoAnticipos(paymentVoucherDto.getAnticipos(), paymentVoucherDto.getIdPaymentVoucher());
            setInfoCamposAdicionales(paymentVoucherDto.getCamposAdicionales(), paymentVoucherDto.getIdPaymentVoucher());
            setInfoCuotas(paymentVoucherDto.getCuotas(), paymentVoucherDto.getIdPaymentVoucher());
            setInfoItems(paymentVoucherDto.getItems(), paymentVoucherDto.getIdPaymentVoucher());
            setInfoGuia(paymentVoucherDto.getGuiasRelacionadas(), paymentVoucherDto.getIdPaymentVoucher());

            Optional<PaymentVoucherModel> payment = findById(paymentVoucherDto.getIdPaymentVoucher());
            if(payment.isEmpty()) {
                throw new ServiceException(LogMessages.ENTITY_NOT_FOUND_EXCEPTION+paymentVoucherDto.getIdPaymentVoucher());
            }

            PaymentVoucherDto model = PaymentVoucherConverter.modelToDto(payment.get());
            log.info(LogMessages.PAYMENT_VOUCHER_UPDATED, model.getIdentificadorDocumento());

            return model;
        } catch (Exception e) {
            log.error(LogMessages.PROCESS_FAILED_LOG, e.getMessage());
            throw new ServiceException(LogMessages.PROCESS_FAILED_EXCEPTION+ e.getMessage());
        }
    }

    private void setInfoGuia(List<GuiaPaymentVoucherDto> guiaPayments, Long idPaymentVoucher) {
        if(guiaPayments != null && !guiaPayments.isEmpty()) {
            for (GuiaPaymentVoucherDto guiaPayment : guiaPayments) {
                guiaPayment.setIdPaymentVoucher(idPaymentVoucher);
            }
            guiaPaymentVoucherService.updateGuiaPaymentVoucher(guiaPayments);
        }
    }

    private void setInfoItems(List<DetailsPaymentVoucherDto> items, Long idPaymentVoucher) {
        if(items != null && !items.isEmpty()) {
            for (DetailsPaymentVoucherDto item : items) {
                item.setIdPaymentVoucher(idPaymentVoucher);
            }
            detailsPaymentVoucherService.updateAllDetailsPaymentVouhcer(items);
        }
    }

    private void setInfoCuotas(List<PaymentCuotasDto> cuotas, Long idPaymentVoucher) {
        if(cuotas != null && !cuotas.isEmpty()) {
            for(PaymentCuotasDto cuotasDto : cuotas) {
                cuotasDto.setIdPaymentVoucher(idPaymentVoucher);
            }
            paymentCuotasService.updateAllPaymentCuotas(cuotas);
        }
    }

    private void setInfoPaymentFiles(List<PaymentVoucherFileDto> paymentFiles, Long idPaymentVoucher) {
        if(paymentFiles != null && !paymentFiles.isEmpty()) {
            for (PaymentVoucherFileDto paymentVoucherFile : paymentFiles) {
                paymentVoucherFile.setIdPaymentVoucher(idPaymentVoucher);
            }
            paymentVoucherFileService.updateAllPaymentVoucherFile(paymentFiles);
        }
    }

    private void setInfoAnticipos(List<AnticipoPaymentVoucherDto> anticipos, Long idPaymentVoucher) {
        if(anticipos != null && !anticipos.isEmpty()) {
            for (AnticipoPaymentVoucherDto anticipo : anticipos) {
                anticipo.setIdPaymentVoucher(idPaymentVoucher);
            }
            anticipoPaymentVoucherService.updateAllAnticipoPaymentVoucher(anticipos);
        }
    }

    private void setInfoCamposAdicionales(List<AditionalFieldPaymentVoucherDto> camposAdicionales, Long idPaymentVoucher) {
        if(camposAdicionales != null && !camposAdicionales.isEmpty()) {
            for (AditionalFieldPaymentVoucherDto camposAdicional : camposAdicionales) {
                camposAdicional.setIdPaymentVoucher(idPaymentVoucher);
                Long id = typeFieldService.getIdByNameTypeField(camposAdicional.getNombreCampo());
                camposAdicional.setId(id);
            }
            aditionalFieldPaymentVoucherService.updateAllAditionalFieldPaymentVoucher(camposAdicionales);
        }
    }

    @Override
    public int savePaymentVoucher(PaymentVoucherDto paymentVoucherDto) {
        return 0;
    }

    @Override
    public int updatePaymentVoucher(PaymentVoucherDto paymentVoucherDto) {
        return mapper.update(PaymentVoucherConverter.dtoToModel(paymentVoucherDto));
    }

    @Override
    public int deletePaymentVoucherById(Long id) {
        return 0;
    }

    @Override
    public PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento) {
        if(identificadorDocumento == null) {
            throw new ServiceException(String.format("%s: el identificadorDocumento no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            PaymentVoucherModel paymentVoucherModel = mapper.findByIdentificadorDocumento(identificadorDocumento);
            PaymentVoucherDto paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);
            if(paymentVoucherDto == null) {
                log.warn("{} - method=findByIdentificadorDocumento, identificadorDocumento={}",
                        LogMessages.WARN_GET, identificadorDocumento);
            } else {
                log.debug("{} - method=findByIdentificadorDocumento, identificadorDocumento={}",
                        LogMessages.SUCCESS_GET, identificadorDocumento);
            }
            return paymentVoucherDto;
        } catch (DataAccessException | PersistenceException e) {
            log.error("{} - method=findByIdentificadorDocumento, identificadorDocumento={}",
                    LogMessages.ERROR_DATABASE, identificadorDocumento, e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            log.error("{} - method=findByIdentificadorDocumento, identificadorDocumento={}",
                    LogMessages.ERROR_UNEXPECTED, identificadorDocumento, e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public Integer getNumeracion(String tipoComprobante, String serie, String ruc) {
        if(tipoComprobante == null || serie == null || ruc == null) {
            throw new ServiceException(String.format("%s: el tipo de comprobante, serie y ruc no pueden ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            Integer numeracion = mapper.getNumeroByTipoComprobanteAndSerieAndRucEmisor(tipoComprobante, serie, ruc);
            log.debug("{} - method=getNumeracion, tipoComprobante={}, serie={}, ruc={}",
                    LogMessages.SUCCESS_GET, tipoComprobante, serie, ruc);
            return numeracion;
        } catch (DataAccessException | PersistenceException e) {
            log.error("{} - method=getNumeracion, tipoComprobante={}, serie={},ruc={}",
                    LogMessages.ERROR_DATABASE, tipoComprobante, serie, ruc, e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            log.error("{} - method=getNumeracion, tipoComprobante={}, serie={}, ruc={}",
                    LogMessages.ERROR_UNEXPECTED, tipoComprobante, serie, ruc, e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public List<PaymentVoucherDto> findListSpecificForSummary(String ruc, String fechaEmision, String tipo, String serie, Integer numero) {
        List<PaymentVoucherDto> listSummaryDto = null;
        try {
            List<PaymentVoucherModel> listSummary = mapper.findListSpecificForSummary(ruc, fechaEmision, tipo, serie, numero);
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
            List<PaymentVoucherModel> listSummary = mapper.findAllForSummaryByRucEmisorAndFechaEmision(rucEmisor, fechaEmision);
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
            result = mapper.updateStateToSendSunatForSummaryDocuments(ids, usuario, fechaModificacion);
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return result;
    }

    @Override
    public int updateComprobantesBySummaryDocuments(List<String> identificadorComprobantes, String estado, String estadoSunat, String usuario, Timestamp fechaModificacion) {
        return mapper.updateComprobantesBySummaryDocuments(identificadorComprobantes, estado, estadoSunat, usuario, fechaModificacion);
    }

    @Override
    public int updateComprobantesOnResumenError(List<String> identificadoresComprobantes, String usuario, Timestamp fechaModificacion) {
        return mapper.updateComprobantesOnResumenError(identificadoresComprobantes, usuario, fechaModificacion)   ;
    }

    @Override
    public PaymentVoucherDto findByRucAndTipoAndSerieAndNumero(String finalRucEmisor, String tipoComprobante, String serie, Integer numero) {
        PaymentVoucherDto paymentVoucherDto = null;
        try {
            PaymentVoucherModel paymentVoucherModel = mapper.findByRucAndTipoAndSerieAndNumero(finalRucEmisor, tipoComprobante, serie, numero);
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
