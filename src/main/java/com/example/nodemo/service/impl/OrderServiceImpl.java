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
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public  class OrderServiceImpl implements OrderInterface {
    private final OrderRepository orderRepository;
    private final CoffeeService coffeeService;

//    @Override
//    public Order getById(Long id) throws Exception {
//        return orderRepository.findById(id).orElseThrow();
//    }

    @Override
    public Order createOrder(OrderCreatedto createDto) throws Exception {
        Order order = new Order();
        order.setOrderCoffees(coffeeService.getByIdCoffee(createDto.getCoffeesId()));
//        coffeeService.getByIdCoffee(createDto.getCoffeesId());
//        order.setSumma(coffeeService.getBySumPrice(createDto.getCoffeesId()));
        return orderRepository.save(order);
    }
    @Override
    public  List<Order> createOrders(List<Long> id) throws Exception {
        Order orders = new Order();
        List<Coffee> coffees = new ArrayList<>();
        int sum =0;
        for (Coffee in:coffees
             ) {
            orders.setOrderCoffees(coffeeService.getByIdCoffee(id));
//            orders.setSumma(coffeeService.getBySumPrice(id));
        }
        return (List<Order>) orderRepository.save(orders);
    }
    private int orderSum(List<Coffee> coffees) {

        return 0;
    }
}
