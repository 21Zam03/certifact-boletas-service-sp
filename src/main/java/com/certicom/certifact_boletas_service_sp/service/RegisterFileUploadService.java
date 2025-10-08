package com.certicom.certifact_boletas_service_sp.service;

import com.certicom.certifact_boletas_service_sp.dto.RegisterFileUploadDto;

public interface RegisterFileUploadService {

    public RegisterFileUploadDto saveRegisterFileUpload(RegisterFileUploadDto registerFileUpload);

    public RegisterFileUploadDto findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc
            (Long idPayment, String tipoArchivo, String estadoArchivo);
    public RegisterFileUploadDto getDataForCdr(Long id, String uuid, String tipo);
    public RegisterFileUploadDto getDataForXml(Long id, String uuid, String tipo);

}
