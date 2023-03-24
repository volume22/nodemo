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

@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingRepository ratingRepository;
    private final RatingInterface ratingInterface;
    @GetMapping("/api/rating/{id}")
    public Rating getById(@PathVariable Long id) throws Exception {
        return ratingInterface.getById(id);
    }
    @PostMapping("/api/rating")
    public Rating createRating(@RequestBody RatingDto ratingDto) throws Exception {
        return ratingInterface.addRatingCoffee(ratingDto);
    }
}
