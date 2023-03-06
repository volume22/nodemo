package com.example.nodemo.repository;

import com.example.nodemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
    List<Object> findById(List<Long> id);
}
