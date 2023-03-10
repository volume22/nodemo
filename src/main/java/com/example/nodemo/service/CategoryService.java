package com.example.nodemo.service;

import com.example.nodemo.model.Category;
import com.example.nodemo.model.Coffee;

public interface CategoryService {
    Category getById(Long id)throws Exception;;
    Long createCategory(String name);
    Category updateCategory(Long id,String name);
    void deleteCategory(Long id)throws Exception;

}
