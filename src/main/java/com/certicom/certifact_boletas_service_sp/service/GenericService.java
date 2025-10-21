package com.certicom.certifact_boletas_service_sp.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    Optional<T> findById(ID id);
    List<T> findAll();
    T save(T entity);
    int update(T entity);
    int delete(ID id);
    int updateAll(List<T> list);
    int deleteAll(List<T> list);
    int saveAll(List<T> list);

}
