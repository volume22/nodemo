package com.example.nodemo.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoffeeCreateDto {
    private String name;
    private Integer quantity;
    private Long categoryId;
    private Long favoritesId;
    private Integer price;
}
