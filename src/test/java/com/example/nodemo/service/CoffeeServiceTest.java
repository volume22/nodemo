package com.example.nodemo.service;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Category;
import com.example.nodemo.model.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Hello test")
public class CoffeeServiceTest {
    @Autowired
    private CoffeeService coffeeService;
    @MockBean
    private CategoryService categoryService;

    @Test
    void createCoffeeTest() throws Exception {
        Category category = new Category();
        category.setId(1L);
        category.setName("Latte");

        CoffeeCreateDto createDto = new CoffeeCreateDto();
        createDto.setName("Tastaq");
        createDto.setPrice(300);
        createDto.setQuantity(7);
        createDto.setCategoryId(category.getId());

/*        Coffee coffee = new Coffee();
        coffee.setCategory(category);
        coffee.setQuantity(700);
        coffee.setName("Alchemist");
        coffee.setId(1L);*/
        var res = coffeeService.createCoffee(createDto);

        Assertions.assertEquals(res.getName(), "Tastaq");
//        Assertions.assertEquals(res.getCategory().getName(), "Classic");
        Assertions.assertEquals(res.getQuantity(), 7);
    }
}
