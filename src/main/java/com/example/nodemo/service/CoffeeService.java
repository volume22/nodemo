package com.example.nodemo.service;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;

import java.util.List;

public interface  CoffeeService {

    Coffee getById(Long id)throws Exception;
    List<Coffee> getByIdCoffee(List<Long> id)throws Exception;

    Coffee createCoffee(CoffeeCreateDto createDto) throws Exception;
    void deleteCoffee(Long id)throws Exception;
    Coffee updateCoffee(Long id,CoffeeCreateDto createDto)throws  Exception;

    List<Coffee> getByLike()throws Exception;

    List<Coffee> getByCategory(String query)throws Exception;
    List<Coffee> getByNameCoffee(String name);
    List<Coffee> getByCategoryName(String query)throws Exception;
}
