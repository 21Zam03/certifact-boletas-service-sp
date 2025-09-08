package com.certicom.certifact_boletas_service_sp.service.impl;

import com.certicom.certifact_boletas_service_sp.converter.*;
import com.certicom.certifact_boletas_service_sp.mapper.*;
import com.certicom.certifact_boletas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_boletas_service_sp.request.PaymentVoucherRequest;
import com.certicom.certifact_boletas_service_sp.response.PaymentVoucherResponse;
import com.certicom.certifact_boletas_service_sp.service.PaymentVoucherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public PaymentVoucherResponse save(PaymentVoucherRequest paymentVoucherRequest) {
        PaymentVoucherResponse model = null;
        int result = 0;
        try {
            PaymentVoucherModel paymentVoucher = PaymentVoucherConverter.requestToModel(paymentVoucherRequest);
            result = paymentVoucherMapper.save(paymentVoucher);
            if(result == 0) {
                throw new RuntimeException("No se pudo registrar el comprobante");
            }
            for (int i=0; i<paymentVoucherRequest.getPaymentVoucherFileModelList().size(); i++) {
                paymentVoucherRequest.getPaymentVoucherFileModelList().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                result = paymentVoucherFileMapper.save(PaymentVoucherFileConverter.requetsToModel(paymentVoucherRequest.getPaymentVoucherFileModelList().get(i)));
                if(result == 0) {
                    throw new RuntimeException("No se pudo registrar el comprobante archivo");
                }
            }
            if(paymentVoucherRequest.getAnticipos() != null && !paymentVoucherRequest.getAnticipos().isEmpty()) {
                for (int i=0; i<paymentVoucherRequest.getAnticipos().size(); i++) {
                    paymentVoucherRequest.getAnticipos().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = anticipoPaymentVoucherMapper.save(AnticipoPaymentVoucherConverter.requestToModel(paymentVoucherRequest.getAnticipos().get(i)));
                    if(result == 0) {
                        throw new RuntimeException("No se pudo registrar el comprobante archivo");
                    }
                }
            }
            if(paymentVoucherRequest.getCamposAdicionales()!= null && !paymentVoucherRequest.getCamposAdicionales().isEmpty()) {
                for (int i = 0; i < paymentVoucherRequest.getCamposAdicionales().size(); i++) {
                    paymentVoucherRequest.getCamposAdicionales().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    Integer id = typeFieldMapper.getIdByName(paymentVoucherRequest.getCamposAdicionales().get(i).getNombreCampo());
                    paymentVoucherRequest.getCamposAdicionales().get(i).setTypeFieldId(id);
                    result = aditionalFieldPaymentVoucherMapper.save(AditionalFIeldPaymentVoucherConverter.requestToModel(paymentVoucherRequest.getCamposAdicionales().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar el campo adicional");
                    }
                }
            }
            if (paymentVoucherRequest.getCuotas() != null && !paymentVoucherRequest.getCuotas().isEmpty()) {
                for (int i = 0; i< paymentVoucherRequest.getCuotas().size(); i++) {
                    paymentVoucherRequest.getCuotas().get(i).setIdPaymentVoucher(paymentVoucherRequest.getIdPaymentVoucher());
                    result = paymentCuotasMapper.save(PaymentCuotasConverter.requestToModel(paymentVoucherRequest.getCuotas().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar la cuota");
                    }
                }
            }
            if(paymentVoucherRequest.getItems() != null && !paymentVoucherRequest.getItems().isEmpty()) {
                for (int i = 0; i < paymentVoucherRequest.getItems().size(); i++) {
                    paymentVoucherRequest.getItems().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = detailsPaymentVoucherMapper.save(DetailsPaymentVoucherConverter.requestToModel(paymentVoucherRequest.getItems().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar los items");
                    }
                }
            }
            if(paymentVoucherRequest.getGuiasRelacionadas() != null && !paymentVoucherRequest.getGuiasRelacionadas().isEmpty()) {
                for (int i = 0; i < paymentVoucherRequest.getGuiasRelacionadas().size(); i++) {
                    paymentVoucherRequest.getGuiasRelacionadas().get(i).setIdPaymentVoucher(paymentVoucher.getIdPaymentVoucher());
                    result = guiaPaymentVoucherMapper.save(GuiaPaymentVoucherConverter.requestToModel(paymentVoucherRequest.getGuiasRelacionadas().get(i)));
                    if(result == 0){
                        throw new RuntimeException("No se pudo registrar la guia relacionada");
                    }
                }
            }
            PaymentVoucherModel payment = paymentVoucherMapper.findById(paymentVoucher.getIdPaymentVoucher());
            model = PaymentVoucherConverter.ModelToResponse(payment);
            if(model==null) {
                throw new RuntimeException("No se pudo obtener el registro de payment");
            }
        } catch (Exception e) {
            log.error("ERROR: {} ",e.getMessage());
        }
        return model;
    }

}
