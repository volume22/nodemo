package com.example.nodemo.service;

import com.example.nodemo.controller.dto.RatingDto;
import com.example.nodemo.model.Rating;

import java.util.List;

public interface RatingInterface {

    Rating addRatingCoffee(RatingDto ratingDto)throws Exception;
    Rating updateRatingCoffee(Long coffeeId, RatingDto ratingDto)throws Exception;

    List<Rating> getByAll();
    List<Rating> getRatingsForEntity(Long coffeeId) throws Exception;
    Double calculateAverageRating(Long coffeeId) throws Exception;
}
