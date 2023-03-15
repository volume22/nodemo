package com.example.nodemo.service.impl;

import com.example.nodemo.model.Favorites;
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
    public List<Favorites> getbyAll() throws Exception {
        return likeRepository.findAll();
    }

    @Override
    public Long createLike(Boolean likes) {
       Favorites like = new Favorites();
       like.setLike(true);
       return likeRepository.save(like).getId();
    }

}
