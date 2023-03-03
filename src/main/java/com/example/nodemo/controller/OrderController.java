package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.CoffeeCreateDto;

import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.model.Order;
import com.example.nodemo.repository.OrderRepository;
import com.example.nodemo.service.OrderInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    public final OrderRepository orderRepository;
    private final OrderInterface orderInterface;
    @GetMapping("/api/orders/{id}")
    public Order getById(@PathVariable Long id) throws Exception {
        return orderInterface.getById(id);
    }

    @PostMapping("/api/order")
    public Order createCoffee(@RequestBody OrderCreatedto createDto) throws Exception {
        return orderInterface.createOrder(createDto);
    }
}
