package com.example.nodemo.service.impl;

import com.example.nodemo.controller.dto.RatingDto;
import com.example.nodemo.model.Coffee;
import com.example.nodemo.model.Rating;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.repository.RatingRepository;
import com.example.nodemo.service.CoffeeService;
import com.example.nodemo.service.RatingInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingInterface {
    private final RatingRepository ratingRepository;
    private final CoffeeService coffeeService;

    @Override
    public Rating getById(Long id) throws Exception {
        return ratingRepository.findById(id).orElseThrow();
    }

    @Override
    public Rating addRatingCoffee(RatingDto ratingDto) throws Exception {
        Rating rating = new Rating();
        rating.setRemark(ratingDto.getRemark());
        rating.setCoffee(coffeeService.getById(ratingDto.getCoffeeId()));
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRatingCoffee(Long id,RatingDto ratingDto) throws Exception {
        Rating rating = ratingRepository.findById(id).orElseThrow();
        return  ratingRepository.save(rating);
    }

    @Override
    public Rating getById(List<Long> ratingId) {
        return null;
    }


}
