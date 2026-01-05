package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.*;
import com.certicom.certifact_boletas_service_sp.dto.*;
import com.certicom.certifact_boletas_service_sp.enums.LogTitle;
import com.certicom.certifact_boletas_service_sp.exception.ServiceException;
import com.certicom.certifact_boletas_service_sp.mapper.*;
import com.certicom.certifact_boletas_service_sp.model.*;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;
import com.certicom.certifact_boletas_service_sp.service.*;
import com.certicom.certifact_boletas_service_sp.util.LogHelper;
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
        //log.debug("Guardando paymentvoucher con datos completos: {}", paymentVoucherDto);
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
            if(paymentVoucherDto.getPaymentVoucherFileDtoList()!=null && !paymentVoucherDto.getPaymentVoucherFileDtoList().isEmpty()) {
                for (int i = 0; i< paymentVoucherDto.getPaymentVoucherFileDtoList().size(); i++) {
                    paymentVoucherDto.getPaymentVoucherFileDtoList().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = paymentVoucherFileMapper.insert(PaymentVoucherFileConverter.dtoToModel(paymentVoucherDto.getPaymentVoucherFileDtoList().get(i)));
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
            Optional<PaymentVoucherModel> payment = findById(paymentVoucher.getIdPaymentVoucher());
            if(payment.isEmpty()) {
                throw new ServiceException(LogMessages.ENTITY_NOT_FOUND_EXCEPTION+paymentVoucherDto.getIdPaymentVoucher());
            }
            model = PaymentVoucherConverter.modelToDto(payment.get());
            log.info(LogMessages.PAYMENT_VOUCHER_SAVED, model.getIdentificadorDocumento());
        } catch (Exception e) {
            watchErrorLogs(e);
        }
        return model;
    }

    @Override
    public PaymentVoucherDto findPaymentVoucherById(Long id) {
        PaymentVoucherModel paymentVoucherModel = mapper.findById(id);
        PaymentVoucherDto paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);

        List<DetailsPaymentVoucherModel> items = detailsPaymentVoucherMapper.findByIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
        System.out.println("CODIGO: "+items.get(0).getCodigoTipoAfectacionIGV());
        List<PaymentCuotasModel> cuotas = paymentCuotasMapper.listCuotasByIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
        List<GuiaPaymentVoucherModel> guias = guiaPaymentVoucherMapper.listGuiasByIdPaymentVoucher(paymentVoucherDto.getIdPaymentVoucher());
        paymentVoucherDto.setItems(DetailsPaymentVoucherConverter.modelListToDtoList(items));
        paymentVoucherDto.setCuotas(PaymentCuotasConverter.modelListToDtoList(cuotas) == null ? List.of() : PaymentCuotasConverter.modelListToDtoList(cuotas));
        paymentVoucherDto.setGuiasRelacionadas(GuiaPaymentVoucherConverter.modelListToDtoList(guias) == null ? List.of() : GuiaPaymentVoucherConverter.modelListToDtoList(guias));
        return paymentVoucherDto;
    }

    @Transactional
    @Override
    public PaymentVoucherDto updatePaymentVoucherProcess(PaymentVoucherDto paymentVoucherDto) {
        updatePaymentVoucher(paymentVoucherDto);
        setInfoPaymentFiles(paymentVoucherDto.getPaymentVoucherFileDtoList(), paymentVoucherDto.getIdPaymentVoucher());
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
    }

    @Override
    public PaymentVoucherDto getPaymentVoucherProcess(String rucEmisor, String tipoComprobante, String serie, Integer numero) {
        return null;
    }

    private void setInfoGuia(List<GuiaPaymentVoucherDto> guiaPayments, Long idPaymentVoucher) {
        if(guiaPayments != null && !guiaPayments.isEmpty()) {
            for (GuiaPaymentVoucherDto guiaPayment : guiaPayments) {
                guiaPayment.setIdPaymentVoucher(idPaymentVoucher);
            }
            guiaPaymentVoucherService.saveAllGuiaPaymentVoucher(guiaPayments);
        }
    }

    private void setInfoItems(List<DetailsPaymentVoucherDto> items, Long idPaymentVoucher) {
        if(items != null && !items.isEmpty()) {
            for (DetailsPaymentVoucherDto item : items) {
                item.setIdPaymentVoucher(idPaymentVoucher);
            }
            detailsPaymentVoucherService.saveAllDetailsPaymentVouhcer(items);
        }
    }

    private void setInfoCuotas(List<PaymentCuotasDto> cuotas, Long idPaymentVoucher) {
        if(cuotas != null && !cuotas.isEmpty()) {
            for(PaymentCuotasDto cuotasDto : cuotas) {
                cuotasDto.setIdPaymentVoucher(idPaymentVoucher);
            }
            paymentCuotasService.saveAllPaymentCuotas(cuotas);
        }
    }

    private void setInfoPaymentFiles(List<PaymentVoucherFileDto> paymentFiles, Long idPaymentVoucher) {
        if(paymentFiles != null && !paymentFiles.isEmpty()) {
            for (PaymentVoucherFileDto paymentVoucherFile : paymentFiles) {
                paymentVoucherFile.setIdPaymentVoucher(idPaymentVoucher);
                if(paymentVoucherFile.getId() == null) {
                    paymentVoucherFileService.savePaymentVoucherFile(paymentVoucherFile);
                } else {
                    paymentVoucherFileService.updatePaymentVoucherFile(paymentVoucherFile);
                }
            }
        }
    }

    private void setInfoAnticipos(List<AnticipoPaymentVoucherDto> anticipos, Long idPaymentVoucher) {
        if(anticipos != null && !anticipos.isEmpty()) {
            for (AnticipoPaymentVoucherDto anticipo : anticipos) {
                anticipo.setIdPaymentVoucher(idPaymentVoucher);
            }
            anticipoPaymentVoucherService.saveAllAnticipoPaymentVoucher(anticipos);
        }
    }

    private void setInfoCamposAdicionales(List<AditionalFieldPaymentVoucherDto> camposAdicionales, Long idPaymentVoucher) {
        if(camposAdicionales != null && !camposAdicionales.isEmpty()) {
            for (AditionalFieldPaymentVoucherDto camposAdicional : camposAdicionales) {
                camposAdicional.setIdPaymentVoucher(idPaymentVoucher);
                Long id = typeFieldService.getIdByNameTypeField(camposAdicional.getNombreCampo());
                camposAdicional.setTypeFieldId(id);
            }
            aditionalFieldPaymentVoucherService.saveAllAditionalFieldPaymentVoucher(camposAdicionales);
        }
    }

    @Override
    public int savePaymentVoucher(PaymentVoucherDto paymentVoucherDto) {
        return 0;
    }

    @Override
    public int updatePaymentVoucher(PaymentVoucherDto paymentVoucherDto) {
        return update(PaymentVoucherConverter.dtoToModel(paymentVoucherDto));
    }

    @Override
    public int deletePaymentVoucherById(Long id) {
        return 0;
    }

    @Override
    public PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento) {
        if(identificadorDocumento == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "parametro identificadorDocumento es nulo");
            throw new ServiceException(String.format("%s: el identificadorDocumento no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            PaymentVoucherModel paymentVoucherModel = mapper.findByIdentificadorDocumento(identificadorDocumento);
            PaymentVoucherDto paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);
            if(paymentVoucherDto == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "variable paymentVoucherDto es nulo");
            } else {
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo exitosamente");
            }
            return paymentVoucherDto;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
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
            List<DetailsPaymentVoucherModel> items = detailsPaymentVoucherMapper.findByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
            List<AditionalFieldPaymentVoucherModel> aditionalFields = aditionalFieldPaymentVoucherMapper.listAditionalFieldByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
            List<AnticipoPaymentVoucherModel> anticipos = anticipoPaymentVoucherMapper.listAnticiposByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
            List<PaymentCuotasModel> cuotas = paymentCuotasMapper.listCuotasByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
            List<GuiaPaymentVoucherModel> guiasRelacionadas = guiaPaymentVoucherMapper.listGuiasByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());
            List<PaymentVoucherFileModel> files = paymentVoucherFileMapper.findAllByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher());

            paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);
            paymentVoucherDto.setItems(DetailsPaymentVoucherConverter.modelListToDtoList(items));
            paymentVoucherDto.setCamposAdicionales(AditionalFIeldPaymentVoucherConverter.modelListToDtoList(aditionalFields));
            paymentVoucherDto.setAnticipos(AnticipoPaymentVoucherConverter.modelListToDtoList(anticipos));
            paymentVoucherDto.setCuotas(PaymentCuotasConverter.modelListToDtoList(cuotas));
            paymentVoucherDto.setGuiasRelacionadas(GuiaPaymentVoucherConverter.modelListToDtoList(guiasRelacionadas));
            paymentVoucherDto.setPaymentVoucherFileDtoList(PaymentVoucherFileConverter.modelListToDtoList(files));
            System.out.println("ANTICIPOS: "+anticipos);
        } catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
        return paymentVoucherDto;
    }

    @Override
    public List<PaymentVoucherDto> findAllByTipoComprobanteInAndNumDocIdentReceptorAndRucEmisorAndTipoOperacionAndEstadoOrderByNumDocIdentReceptor(List<String> tipoComprobante, String numDocIdentReceptor, String rucEmisor, String tipoOperacion, String estado) {
        List<PaymentVoucherModel> list = mapper.findAnticipos(tipoComprobante, numDocIdentReceptor, rucEmisor, tipoOperacion, estado);
        System.out.println("LIST: "+list);
        for (PaymentVoucherModel paymentVoucherModel : list) {
            List<AnticipoPaymentVoucherDto> anticipos = AnticipoPaymentVoucherConverter.modelListToDtoList(anticipoPaymentVoucherMapper.listAnticiposByIdPaymentVoucher(paymentVoucherModel.getIdPaymentVoucher()));
            paymentVoucherModel.setAnticipos(anticipos);
        }
        return PaymentVoucherConverter.modelListToDtoList(list) == null ? List.of() : PaymentVoucherConverter.modelListToDtoList(list);
    }

    @Override
    public List<PaymentVoucherDto> getPaymentVocuherByCredito(String numDocIdentReceptor, String rucEmisor) {
        List<PaymentVoucherModel> list = mapper.findCreditos(numDocIdentReceptor, rucEmisor);
        return PaymentVoucherConverter.modelListToDtoList(list) == null ? List.of() : PaymentVoucherConverter.modelListToDtoList(list);
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
