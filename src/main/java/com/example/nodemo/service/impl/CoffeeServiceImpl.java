package com.example.nodemo.service.impl;

import com.example.nodemo.model.Coffee;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.service.CoffeeService;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Coffee getById(Long id) {
        return coffeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Long createCoffee(String name, Integer quantity,Integer price) {
        Coffee coffee = new Coffee();
        coffee.setName(name);
        coffee.setQuantity(quantity);
        coffee.setPrice(price);
        return coffeeRepository.save(coffee).getId();
    }
}
