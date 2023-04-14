package com.example.nodemo.service.impl;

import com.example.nodemo.model.Coffee;
import com.example.nodemo.model.Favorites;
import com.example.nodemo.repository.CoffeeRepository;
import com.example.nodemo.repository.LikeRepository;
import com.example.nodemo.service.CoffeeService;
import com.example.nodemo.service.LikeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritesServiceImpl implements LikeInterface {
    private final LikeRepository likeRepository;

    @Override
    public List<Favorites> getbyAll() throws Exception {
        return likeRepository.findAll();
    }

    @Override
    public Favorites getbyId(Long id) throws Exception {
        return likeRepository.findById(id).orElseThrow();
    }

    @Override
    public Long createLike(Boolean fav) {
        Favorites like = new Favorites();
        like.setFav(fav);
        return likeRepository.save(like).getId();
    }

    @Override
    public Favorites update(Long id, Boolean fav) throws Exception {
        Favorites favorites = likeRepository.findById(id).orElseThrow();
        if (id != null) {
            favorites.setFav(fav);
        }
        return likeRepository.save(favorites);
    }


}
