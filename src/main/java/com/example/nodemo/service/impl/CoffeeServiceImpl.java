package com.example.nodemo.service.impl;

import com.example.nodemo.controller.dto.CoffeeCreateDto;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.model.Rating;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.service.CategoryService;
import com.example.nodemo.service.CoffeeService;
import com.example.nodemo.service.LikeInterface;
import com.example.nodemo.service.RatingInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final CategoryService categoryService;
    private final LikeInterface likeInterface;


    @Override
    public Coffee getById(Long id) {
        return coffeeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Coffee> getByIdCoffee(List<Long> id) {
        return coffeeRepository.findAllById(id).stream().toList();
    }

    @Override
    public Coffee createCoffee(CoffeeCreateDto createDto) throws Exception {
        Coffee coffee = new Coffee();
        coffee.setName(createDto.getName());
        coffee.setQuantity(createDto.getQuantity());
        coffee.setPrice(createDto.getPrice());
        coffee.setCategory(categoryService.getById(createDto.getCategoryId()));
        coffee.setFavorites(likeInterface.getbyId(createDto.getFavoritesId()));
        return coffeeRepository.save(coffee);
    }
    @Override
    public void deleteCoffee(Long id)throws Exception{
        coffeeRepository.deleteById(id);
    }

    @Override
    public Coffee updateCoffee(Long id,CoffeeCreateDto createDto)throws Exception{
       Coffee coffee=coffeeRepository.findById(id).orElseThrow();
       if (id!=null){
        coffee.setName(createDto.getName());
        coffee.setQuantity(createDto.getQuantity());
        coffee.setPrice(createDto.getPrice());
        coffee.setCategory(categoryService.getById(createDto.getCategoryId()));
        coffee.setFavorites(likeInterface.getbyId(createDto.getFavoritesId()));
       }
        return coffeeRepository.save(coffee);
    }


    @Override
    public List<Coffee> getByLike() throws Exception {
        return coffeeRepository.findAllByFavorites_FavIsTrue();
    }

    @Override
    public List<Coffee> getByCategory(String query) throws Exception {
        return coffeeRepository.searchByCategory_Name(query);
    }

}
