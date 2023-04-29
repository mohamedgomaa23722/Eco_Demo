package com.mg.eco.bussiness.services;


import com.mg.eco.bussiness.dtos.Message;

import java.util.List;

public interface Service<T,R> {
    List<R> getAll(int page);
    Message insert(R object);
    Message update(R object, int id);
    Message delete(int id);
    R findById(int id);
    List<R> findByName(String name, String fieldName, int page);
    T isExist(String name, String fieldName);
}
