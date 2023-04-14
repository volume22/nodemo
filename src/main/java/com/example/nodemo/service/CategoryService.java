package com.example.nodemo.service;

import com.example.nodemo.model.Category;
import com.example.nodemo.model.Coffee;

import java.util.List;

public interface CategoryService {
    Category getById(Long id)throws Exception;;
    Long createCategory(String name);
    Category updateCategory(Long id,String name);
    void deleteCategory(Long id)throws Exception;
    List<Category> getByNameCategory(String query);
    List<Category> getByAll();

}
