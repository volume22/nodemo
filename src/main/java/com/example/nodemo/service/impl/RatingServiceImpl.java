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
public class
RatingServiceImpl implements RatingInterface {
    private final RatingRepository ratingRepository;
    private final CoffeeService coffeeService;


    @Override
    public Rating addRatingCoffee(RatingDto ratingDto) throws Exception {
        Rating rating = new Rating();
        rating.setRemark(ratingDto.getRemark());
        rating.setCoffee(coffeeService.getById(ratingDto.getCoffeeId()));
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRatingCoffee(Long coffeeId, RatingDto ratingDto) throws Exception {
        Rating rating = ratingRepository.findById(coffeeId).orElseThrow();
        rating.setRemark(ratingDto.getRemark());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getByAll() {
        return ratingRepository.findAll().stream().toList();
    }

    @Override
    public List<Rating> getRatingsForEntity(Long coffeeId) throws Exception {
        return ratingRepository.findAllByCoffee_Id(coffeeId);
    }

    @Override
    public Double calculateAverageRating(Long coffeeId) throws Exception {
        List<Rating> ratings = getRatingsForEntity(coffeeId);
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = ratings.stream().mapToDouble(Rating::getRemark).sum();
        return sum / ratings.size();
    }


}
