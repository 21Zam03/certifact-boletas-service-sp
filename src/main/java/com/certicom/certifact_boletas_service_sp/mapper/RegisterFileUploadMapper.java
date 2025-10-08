package com.certicom.certifact_boletas_service_sp.mapper;

import com.certicom.certifact_boletas_service_sp.model.RegisterFileUploadModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterFileUploadMapper extends BaseMapper<RegisterFileUploadModel, Long> {

    //int save(RegisterFileUploadModel registerFileUploadModel);
    //public RegisterFileUploadModel findById(Long id);

    public RegisterFileUploadModel findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(
            @Param("id") Long idPayment, @Param("tipo") String tipoArchivo, @Param("estado") String estado
    );
    public RegisterFileUploadModel getDataForCdr(Long id, String uuid, String tipo);
    public RegisterFileUploadModel getDataForXml(Long id, String uuid, String tipo);


}
