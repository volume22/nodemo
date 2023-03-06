package com.example.nodemo.service;



import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.model.Order;

import java.util.List;

public interface OrderInterface {
//    Order getById(Long id)throws Exception;
    Order createOrder(OrderCreatedto createDto) throws Exception;
    List<Order> createOrders(List<Long> id) throws  Exception;
}
