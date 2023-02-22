package com.example.nodemo.service;

import com.example.nodemo.model.Coffee;

public interface CoffeeService {

    Coffee getById(Long id)throws Exception;;

    Long createCoffee(String name, Integer quantity,Integer price);
}
