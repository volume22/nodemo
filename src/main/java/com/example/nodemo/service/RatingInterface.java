package com.example.nodemo.service;

import com.example.nodemo.controller.dto.RatingDto;
import com.example.nodemo.model.Rating;

import java.util.List;

public interface RatingInterface {
    Rating getById(Long id)throws Exception;
    Rating addRatingCoffee(RatingDto ratingDto)throws Exception;
    Rating updateRatingCoffee(Long id, RatingDto ratingDto)throws Exception;

    Rating getById(List<Long> ratingId);
}
