package com.certicom.certifact_boletas_service_sp.util;


public class LogMessages {

    public static final String PAYMENT_VOUCHER_SAVED = "Se actualizó la entidad payment_voucher exitosamente, identificador: {}";
    public static final String PAYMENT_VOUCHER_UPDATED = "Se actualizó la entidad payment_voucher exitosamente, identificador: {}";
    public static final String PAYMENT_VOUCHER_NOT_FOUND = "PaymentVoucher no encontrado con ID: {}";
    public static final String PAYMENT_VOUCHER_NOT_UPDATE = "No se pudo actualizar la entidad payment_voucher, id: {}";


    // Error
    public static final String PAYMENT_VOUCHER_SAVE_FAILED = "Error guardando PaymentVoucher: {}";

    // Debug
    public static final String PAYMENT_VOUCHER_SQL_EXECUTED = "SQL ejecutado para PaymentVoucher: {}";


    public static final String PAYMENT_VOUCHER_FILE_NOT_UPDATE = "No se pudo actualizar la entidad payment_voucher_file, id: {}";

    public static final String ANTICIPO_PAYMENT_VOUCHER_NOT_UPDATE = "No se pudo actualizar la entidad anticipo_payment_voucher, id: {}";
    public static final String ADITIONAL_FIELD_PAYMENT_VOUCHER_NOT_UPDATE = "No se pudo actualizar la entidad aditional_field_payment_voucher, id: {}";
    public static final String PAYMENT_CUOTAS_NOT_UPDATE = "No se pudo actualizar la entidad payment_cuotas, id: {}";
    public static final String DETAILS_PAYMENT_VOUCHER_NOT_UPDATE = "No se pudo actualizar la entidad details_payment_voucher, id: {}";
    public static final String GUIA_PAYMENT_VOUCHER_NOT_UPDATE = "No se pudo actualizar la entidad guia_payment_voucher, id: {}";

    public static final String PROCESS_FAILED_LOG = "Error en el proceso, error: {}";
    public static final String PROCESS_FAILED_EXCEPTION = "Error en el proceso, error:";
    public static final String ERROR_EXCEPTION = "Error: ";

    //LOGS HACIENDO CONSULTAS A BASE DE DATOS
    public static final String ENTITY_NOT_FOUND = "Entidad no encontrada con id: {}";
    public static final String ENTITY_NOT_FOUND_EXCEPTION = "Entidad no encontrada con id: ";
    public static final String ENTITY_FOUND_ERROR = "Error al obtener la entidad, error={}";
    public static final String ENTITY_LIST_EMPTY = "Se obtuvo la lista vacia";
    public static final String ENTITY_LIST_ERROR = "Error al obtener lista de entidades, error={}";
    public static final String ENTITY_NOT_CREATED = "No se pudo guardar la entidad en base de datos, entity={}";
    public static final String ENTITY_SAVE_ERROR = "Error al guardar la entidad, error={}";
    public static final String ENTITY_NOT_UPDATED = "No se pudo actualizar la entidad en base de datos, entity={}";
    public static final String ENTITY_UPDATE_ERROR = "Error al actualizar la entidad, error={}";
    public static final String ENTITY_NOT_DELETED = "No se pudo eliminar la entidad en base da datos";
    public static final String ENTITY_DELETE_ERROR = "Error al eliminar la entidad, error={}";
    public static final String ENTITY_LIST_NOT_UPDATED = "No se pudo actualizar la lista de entidades en base de datos";
    public static final String ENTITY_LIST_UPDATED_ERROR = "Error al actualizar las entidades, error={}";

    public static final String ENTITY_LIST_UPDATED = "Se actualizaron las entidades, count={}";


    public static final String PARAMETER_NOT_NULL = "Parametro no puede ser nulo";
    public static final String RESULT_NULL = "El valor de la respuesta de la query es nula";

    public static final String PROCESS_START_1 = "Iniciando proceso transaccional, parameter: {}";

}
