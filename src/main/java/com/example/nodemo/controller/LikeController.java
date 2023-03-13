package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.CategoryCreatedto;
import com.example.nodemo.controller.dto.LikeCreateDto;
import com.example.nodemo.model.Category;
import com.example.nodemo.model.Like;
import com.example.nodemo.service.CategoryService;
import com.example.nodemo.service.LikeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeInterface likeInterface;
    @GetMapping("/api/likes/{id}")
    public List<Like> getByAll() throws Exception {
        return likeInterface.getbyAll();
    }
    @PostMapping("/api/likes")
    public Long createCoffee(@RequestBody LikeCreateDto createDto) {
        return likeInterface.createLike(createDto.isLike());
    }
}
