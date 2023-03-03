package com.example.nodemo.service;



import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.model.Order;

public interface OrderInterface {
    Order getById(Long id)throws Exception;
    Order createOrder(OrderCreatedto createDto) throws Exception;

}
