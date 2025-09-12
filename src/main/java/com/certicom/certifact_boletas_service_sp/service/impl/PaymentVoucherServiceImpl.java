package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.*;
import com.certicom.certifact_boletas_service_sp.mapper.*;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.dto.PaymentVoucherDto;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PaymentVoucherDto save(PaymentVoucherDto paymentVoucherDto) {
        PaymentVoucherDto model = null;
        int result = 0;
        try {
            PaymentVoucherModel paymentVoucher = PaymentVoucherConverter.dtoToModel(paymentVoucherDto);
            result = paymentVoucherMapper.save(paymentVoucher);
            if(result == 0) {
                throw new RuntimeException("No se pudo registrar el comprobante");
            }
            for (int i = 0; i< paymentVoucherDto.getPaymentVoucherFileModelList().size(); i++) {
                paymentVoucherDto.getPaymentVoucherFileModelList().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                result = paymentVoucherFileMapper.save(PaymentVoucherFileConverter.requetsToModel(paymentVoucherDto.getPaymentVoucherFileModelList().get(i)));
                if(result == 0) {
                    throw new RuntimeException("No se pudo registrar el comprobante archivo");
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
            watchLogs(e);
        }
        return model;
    }

    @Override
    public PaymentVoucherDto update(PaymentVoucherDto paymentVoucherDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public PaymentVoucherDto findByIdentificadorDocumento(String identificadorDocumento) {
        PaymentVoucherDto paymentVoucherDto = null;
        try {
            PaymentVoucherModel paymentVoucherModel = paymentVoucherMapper.findByIdentificadorDocumento(identificadorDocumento);
            if(paymentVoucherModel!=null) {
                paymentVoucherDto = PaymentVoucherConverter.modelToDto(paymentVoucherModel);
            }
        } catch (Exception e) {
            watchLogs(e);
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
            if (listSummary != null && !listSummary.isEmpty()) {
                listSummaryDto = PaymentVoucherConverter.modelListToDtoList(listSummary);
            }
        } catch (Exception e) {
            watchLogs(e);
        }
        return listSummaryDto;
    }

    private void watchLogs(Exception e) {
        log.error("ERROR: {}", e.getMessage());
    }

}
