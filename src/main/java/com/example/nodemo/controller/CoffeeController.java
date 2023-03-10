package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoffeeController {
    public final CoffeeRepository coffeeRepository;
    private final CoffeeService coffeeService;
    @GetMapping("/api/coffees/{id}")
    public Coffee getById(@PathVariable Long id) throws Exception {
        return coffeeService.getById(id);
    }

    @GetMapping("/api/coffee/{id}")
    public List<Coffee> getByIdCoffee(@PathVariable List<Long> id) throws Exception {
        return coffeeService.getByIdCoffee(id);
    }

    @PostMapping("/api/coffees")
    public Coffee createCoffee(@RequestBody CoffeeCreateDto createDto) throws Exception {
        return coffeeService.createCoffee(createDto);
    }
    @DeleteMapping ("/api/coffee/{id}")
    public void deleteCoffee(@PathVariable Long id) throws Exception {
        coffeeService.deleteCoffee(id);
    }
    @PutMapping("/api/coffee/{id}")
    public Coffee updateCoffee( @PathVariable Long id,@RequestBody CoffeeCreateDto createDto) throws Exception {
        return coffeeService.updateCoffee(id,createDto);
    }
}
