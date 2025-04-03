package com.page.dao;

import java.util.List;

public interface IDao <T> {
    T register(T t);
    T searchField(String field);
    T searchID(Integer id);
    List<T> searchAll();

}