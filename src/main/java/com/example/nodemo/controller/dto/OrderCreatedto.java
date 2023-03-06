package com.example.nodemo.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreatedto {
    private List<Long> coffeesId;
//    private Long coffeesId;
    private Integer summa;
}
