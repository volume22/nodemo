package com.example.nodemo.service.impl;

import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.model.Order;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.repository.OrderRepository;
import com.example.nodemo.service.CategoryService;
import com.example.nodemo.service.CoffeeService;
import com.example.nodemo.service.OrderInterface;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public  class OrderServiceImpl implements OrderInterface {
    private final OrderRepository orderRepository;
    private final CoffeeService coffeeService;


    @Override
    public Order getById(Long id) throws Exception {
        return orderRepository.findById(id).orElseThrow();
    }
    @Override
    public Order getByAll() throws Exception {
        return (Order) orderRepository.findAll().stream().toList();
    }

    @Override
    public  Order createOrder(List<Long> ids) throws Exception {
        Order order = new Order();
        List<Coffee> coffees = new ArrayList<>();

        for (Long in : ids) {
            coffees.add(coffeeService.getById(in));
        }

        int sum = orderSum(coffees);

        order.setOrderCoffees(coffees);
        order.setSumma(sum);

        return orderRepository.save(order);
    }
    private int orderSum(List<Coffee> coffees) {
        int sum = 0;

        for (Coffee coffee : coffees) {
            sum += coffee.getPrice() * coffee.getQuantity();
        }

        return sum;
    }
    @Override
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
