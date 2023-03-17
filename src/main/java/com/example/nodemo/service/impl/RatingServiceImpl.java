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

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingInterface {
    private final RatingRepository ratingRepository;

    @Override
    public Rating getbyId(Long id) throws Exception {
        return ratingRepository.findById(id).orElseThrow();
    }

    @Override
    public Rating addRatingCoffee(Integer remark) throws Exception {
        Rating rating = new Rating();
        rating.setRemark(remark);
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRatingCoffee(Long id,Integer ratingDto) throws Exception {
        Rating rating = ratingRepository.findById(id).orElseThrow();
        rating.setRemark(ratingDto);
        return  ratingRepository.save(rating);
    }

}
