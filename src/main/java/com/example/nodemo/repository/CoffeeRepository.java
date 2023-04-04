package com.example.nodemo.repository;

import com.example.nodemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
//    @Query(value ="SELECT * FROM coffees WHERE ", nativeQuery = true)
    List<Coffee> findAllByFavorites_FavIsTrue();
    List<Coffee> searchByCategory_Name(String query);
}
