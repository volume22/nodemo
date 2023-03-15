package com.example.nodemo.service;

import com.example.nodemo.model.Favorites;

import java.util.List;

public interface LikeInterface {
    List<Favorites> getbyAll()throws Exception;
    Favorites getbyId(Long id)throws Exception;
    Long createLike(Boolean fav)throws Exception;
    Favorites update(Long id,Boolean fav)throws Exception;

}
