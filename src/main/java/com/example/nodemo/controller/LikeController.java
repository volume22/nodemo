package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.LikeCreateDto;
import com.example.nodemo.model.Favorites;
import com.example.nodemo.service.LikeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeInterface likeInterface;
    @GetMapping("/api/favorite/{id}")
    public List<Favorites> getByAll() throws Exception {
        return likeInterface.getbyAll();
    }
    @PostMapping("/api/favorites")
    public Long createCoffee(@RequestBody LikeCreateDto createDto) {
        return likeInterface.createLike(createDto.isLike());
    }
}
