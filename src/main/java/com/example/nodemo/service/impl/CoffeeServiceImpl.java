package com.example.nodemo.service.impl;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.service.CategoryService;
import com.example.nodemo.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final CategoryService categoryService;

    @Override
    public Coffee getById(Long id) {
        return coffeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Coffee createCoffee(CoffeeCreateDto createDto) throws Exception {
        Coffee coffee = new Coffee();
        coffee.setName(createDto.getName());
        coffee.setQuantity(createDto.getQuantity());
        coffee.setPrice(createDto.getPrice());
        coffee.setCategory(categoryService.getById(createDto.getCategoryId()));
        return coffeeRepository.save(coffee);
    }
}
