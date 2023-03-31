package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.CategoryCreatedto;
import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Category;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/api/categories/{id}")
    public Category getById(@PathVariable Long id) throws Exception {
        return categoryService.getById(id);
    }
    @PostMapping("/api/categories")
    public Long createCategory(@RequestBody CategoryCreatedto createDto) {
        return categoryService.createCategory(createDto.getName());
    }
    @PutMapping("/api/categories/{id}")
    public Category updateCategory( @PathVariable Long id,@RequestBody CategoryCreatedto createDto) throws Exception {
        return categoryService.updateCategory(id,createDto.getName());
    }
    @DeleteMapping ("/api/categories/{id}")
    public void deleteCategory( @PathVariable Long id) throws Exception {
        categoryService.deleteCategory(id);
    }
}
