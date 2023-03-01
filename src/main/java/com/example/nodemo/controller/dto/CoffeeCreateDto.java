package com.example.nodemo.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeCreateDto {
    private String name;
    private Integer quantity;
    private Long categoryId;
    private Integer price;
}
