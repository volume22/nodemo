package com.example.nodemo.service;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;

import java.util.List;

public interface CoffeeService {

    Coffee getById(Long id)throws Exception;
    List<Coffee> getByIdCoffee(List<Long> id)throws Exception;

    Integer getBySumPrice(Long id)throws Exception;
    Coffee createCoffee(CoffeeCreateDto createDto) throws Exception;


}
