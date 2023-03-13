package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.CoffeeCreateDto;

import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.model.Order;
import com.example.nodemo.repository.OrderRepository;
import com.example.nodemo.service.OrderInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    public final OrderRepository orderRepository;
    private final OrderInterface orderInterface;
    @GetMapping("/api/orders/{id}")
    public Order getById(@PathVariable Long id) throws Exception {
        return orderInterface.getById(id);
    }

    @GetMapping("/api/order")
    public Order getByAll() throws Exception {
        return orderInterface.getByAll();
    }
    @PostMapping("/api/order")
    public Order createOrder(@RequestBody OrderCreatedto createdto) throws Exception {
        return orderInterface.createOrder(createdto.getCoffeesId());
    }
    @DeleteMapping ("/api/order/{id}")
    public void deleteOrder(@PathVariable Long id) throws Exception {
         orderInterface.deleteOrder(id);
    }
}
