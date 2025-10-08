package com.certicom.certifact_boletas_service_sp.util;


public class LogMessages {

    public static final String PAYMENT_VOUCHER_UPDATED = "Se actualizó la entidad payment_voucher exitosamente, identificador: {}";

    public static final String PROCESS_FAILED_LOG = "Error en el proceso, error: {}";
    public static final String PROCESS_FAILED_EXCEPTION = "Error en el proceso, error:";
    public static final String ERROR_EXCEPTION = "Error: ";

    //LOGS HACIENDO CONSULTAS A BASE DE DATOS
    public static final String ENTITY_NOT_FOUND_EXCEPTION = "Entidad no encontrada con id: ";


    public static final String PARAMETER_NOT_NULL = "Parametro no puede ser nulo";
    public static final String RESULT_NULL = "El valor de la respuesta de la query es nula";

    public static final String PROCESS_START_1 = "Iniciando proceso transaccional, parameter: {}";


    public static final String ERROR_UNEXPECTED = "Error inesperado en la capa de servicio";
    public static final String ERROR_DATABASE = "Error en base de datos";
    public static final String ERROR_VALIDATION = "Error de validación";
    public static final String SUCCESS_GET = "Consulta exitosa";
    public static final String WARN_GET = "Consulta a medias";
    public static final String SUCCESS_UPDATE = "Actualización exitosa";
    public static final String WARN_UPDATE = "Actualización a medias";
    public static final String SUCCESS_DELETE = "Eliminación exitosa";
    public static final String WARN_DELETE = "Eliminación a medias";
    public static final String SUCCESS_SAVE = "Registro exitoso";
    public static final String WARN_SAVE = "Registro a medias";

    public static String currentMethod() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
