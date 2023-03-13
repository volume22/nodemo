package com.example.nodemo.service.impl;

import com.example.nodemo.model.Like;
import com.example.nodemo.repository.CategoryRepository;
import com.example.nodemo.repository.LikeRepository;
import com.example.nodemo.service.LikeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeInterface {
    private final LikeRepository likeRepository;
    @Override
    public List<Like>  getbyAll() throws Exception {
        return likeRepository.findAll();
    }

    @Override
    public Long createLike(Boolean likes) {
       Like like = new Like();
       like.setLike(true);
       return likeRepository.save(like).getId();
    }

}
