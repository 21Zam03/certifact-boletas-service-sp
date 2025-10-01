package com.certicom.certifact_boletas_service_sp.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    Optional<T> findById(ID id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(ID id);
    int updateAll(List<T> list);

}
