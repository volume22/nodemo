package com.example.nodemo.repository;

import com.example.nodemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
//    @Query(value ="SELECT * FROM coffees WHERE ", nativeQuery = true)
    List<Coffee> findAllByFavorites_FavIsTrue();
    List<Coffee> searchByCategory_Name(String query);
    List<Coffee> findAllByCategory_NameContaining(String query);
    List<Coffee> findAllByCategory_NameOrderByNameAsc(String query);
    List<Coffee> findAllByCategoryContaining(String query);
    @Query(value = "SELECT * FROM coffees  WHERE category.name LIKE %:title%",nativeQuery = true)
    List<Coffee> searchByCategory_NameLike(@Param("title") String title);
    List<Coffee> findAllByNameContainingIgnoreCase(String query);

//    @Query(value = "SELECT * FROM coffees  WHERE name LIKE '%{':}%'",nativeQuery = true)
//    List<Coffee> searchByNameLike(@Param("name") String name);
}
