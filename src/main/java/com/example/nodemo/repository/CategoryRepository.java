package com.example.nodemo.repository;

import com.example.nodemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByNameIgnoreCase(String query);
}
