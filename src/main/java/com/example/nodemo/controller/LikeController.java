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
    @GetMapping("/api/favorite")
    public List<Favorites> getByAll() throws Exception {
        return likeInterface.getbyAll();
    }
    @GetMapping("/api/favorites/{id}")
    public Favorites getById(@PathVariable Long id) throws Exception {
        return likeInterface.getbyId(id);
    }

    @PostMapping("/api/favorites")
    public Long createCoffee(@RequestBody LikeCreateDto createDto) throws Exception {
        return likeInterface.createLike(createDto.getFav());
    }

    @PutMapping("/api/favorites/{id}")
    public Favorites updateLike(@PathVariable Long id,@RequestBody LikeCreateDto createDto) throws Exception {
        return likeInterface.update(id,createDto.getFav());
    }

}
