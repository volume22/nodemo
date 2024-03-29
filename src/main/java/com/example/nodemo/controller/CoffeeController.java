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
    private final CoffeeService coffeeService;
    @GetMapping("/api/coffees/{id}")
    public Coffee getById(@PathVariable Long id) throws Exception {
        return coffeeService.getById(id);
    }

    @GetMapping("/api/coffee/{id}")
    public List<Coffee> getByIdCoffee(@PathVariable List<Long> id) throws Exception {
        return coffeeService.getByIdCoffee(id);
    }
    @GetMapping("/api/coffee-all")
    public List<Coffee> getByAll() throws Exception {
        return coffeeService.getByAll();
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
    @PutMapping("/api/coffee-like/{id}")
    public Coffee updateCoffeeLike( @PathVariable Long id,@RequestBody CoffeeCreateDto createDto) throws Exception {
        return coffeeService.updateCoffeeLike(id,createDto);
    }
    @GetMapping("/api/coffee-like")
    public List<Coffee> isTrue() throws Exception {
        return coffeeService.getByLike();
    }
    @GetMapping("/api/coffee-category")
    public List<Coffee> searchCategory(@RequestParam(required = false) String query) throws Exception {
        return coffeeService.getByCategory(query);
    }
    @GetMapping("/api/coffee-name")
    public List<Coffee> searchName(@RequestParam(required = false) String name) throws Exception {
        return coffeeService.getByNameCoffee(name);
    }
}
