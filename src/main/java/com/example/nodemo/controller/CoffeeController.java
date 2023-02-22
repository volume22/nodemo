package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;
    @GetMapping("/api/coffee/{id}")
    public Coffee getById(@PathVariable Long id) throws Exception {
        return coffeeService.getById(id);
    }

    @PostMapping("/api/coffees")
    public Long createCoffee(@RequestBody CoffeeCreateDto createDto) {
        return coffeeService.createCoffee(createDto.getName(), createDto.getQuantity(),createDto.getPrice());
    }
}
