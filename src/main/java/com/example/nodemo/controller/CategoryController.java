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
    public Long createCoffee(@RequestBody CategoryCreatedto createDto) {
        return categoryService.createCategory(createDto.getName());
    }
}
