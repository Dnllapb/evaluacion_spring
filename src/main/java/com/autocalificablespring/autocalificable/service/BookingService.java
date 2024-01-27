package com.autocalificablespring.autocalificable.service;

import java.util.List;

public interface BookingService <T>{
    void save(T dto);
    T findById(Object id) throws Exception;
    List<T> findAll();
    void delete(Object id);
}
