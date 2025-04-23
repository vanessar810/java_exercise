package com.dentalclinic.clinic.dao;

import java.util.List;

public interface IDao<T> {
    T create (T t);
    T readbyId(Integer id);
    List<T> readAll();
    void update(T t);
    void delete(Integer id);
}
