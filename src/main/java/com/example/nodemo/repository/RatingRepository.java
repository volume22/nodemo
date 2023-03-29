package com.example.nodemo.repository;

import com.example.nodemo.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    List<Rating> findAllByCoffee_Id(Long coffeeId);
}
