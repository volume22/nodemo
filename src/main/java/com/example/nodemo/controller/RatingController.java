package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.controller.dto.RatingDto;
import com.example.nodemo.model.Order;
import com.example.nodemo.model.Rating;
import com.example.nodemo.repository.OrderRepository;
import com.example.nodemo.repository.RatingRepository;
import com.example.nodemo.service.OrderInterface;
import com.example.nodemo.service.RatingInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingRepository ratingRepository;
    private final RatingInterface ratingInterface;
    @GetMapping("/api/ratings")
    public List<Rating> getByAll() throws Exception {
        return ratingInterface.getByAll();
    }
    @PostMapping("/api/rating")
    public Rating createRating(@RequestBody RatingDto ratingDto) throws Exception {
        return ratingInterface.addRatingCoffee(ratingDto);
    }
    @PutMapping("/api/rating/{coffeeId}")
    public Rating updateRatingCoffee(@PathVariable Long coffeeId,@RequestBody RatingDto ratingDto) throws Exception {
        return ratingInterface.updateRatingCoffee(coffeeId,ratingDto);
    }
    @GetMapping("api/rating/avgrating/{coffeeId}")
    public Double calculateAverageRating(@PathVariable Long coffeeId) throws Exception {
        return ratingInterface.calculateAverageRating(coffeeId);
    }
    @GetMapping("api/rating/rating/{coffeeId}")
    public List<Rating> getRatingsForEntity(@PathVariable Long coffeeId) throws Exception {
        return ratingInterface.getRatingsForEntity(coffeeId);
    }
}
