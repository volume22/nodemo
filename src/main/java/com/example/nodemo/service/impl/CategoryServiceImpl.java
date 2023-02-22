package com.example.nodemo.service.impl;

import com.example.nodemo.model.Category;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.repository.CategoryRepository;
import com.example.nodemo.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Long createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category).getId();
    }
}
