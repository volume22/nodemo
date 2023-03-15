package com.example.nodemo.service;

import com.example.nodemo.model.Favorites;

import java.util.List;

public interface LikeInterface {
    List<Favorites> getbyAll()throws Exception;
    Long createLike(Boolean like);

}
