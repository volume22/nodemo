package com.example.nodemo.service;

import com.example.nodemo.model.Like;

import java.util.List;

public interface LikeInterface {
    List<Like> getbyAll()throws Exception;
    Long createLike(Boolean likes);

}
