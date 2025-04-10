package com.dentalclinic.dao;

import java.util.List;

public interface IDao<T> {
    T create (T t);
    T readbyId(Integer id);
    List<T> readAll();

}
