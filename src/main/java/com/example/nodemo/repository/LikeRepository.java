package com.example.nodemo.repository;

import com.example.nodemo.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LikeRepository extends JpaRepository<Favorites,Long> {
}
