package com.example.nodemo.repository;

import com.example.nodemo.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LikeRepository extends JpaRepository<Like,Long> {
}
