package com.example.nodemo.service;

import com.example.nodemo.controller.dto.RatingDto;
import com.example.nodemo.model.Rating;

public interface RatingInterface {
    Rating getbyId(Long id)throws Exception;
    Rating addRatingCoffee( Integer remark)throws Exception;
    Rating updateRatingCoffee(Long id,Integer ratingDto)throws Exception;
}
