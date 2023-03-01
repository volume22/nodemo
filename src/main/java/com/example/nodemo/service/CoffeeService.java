package com.example.nodemo.service;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;

public interface CoffeeService {

    Coffee getById(Long id)throws Exception;;

    Coffee createCoffee(CoffeeCreateDto createDto) throws Exception;
}
