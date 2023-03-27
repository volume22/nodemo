package com.example.nodemo.service;

import com.example.nodemo.controller.dto.UserCreateDto;
import com.example.nodemo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
//    User createUser(UserCreateDto createDto)throws Exception;
//    void updateUser(Long id, UserCreateDto createDto)throws Exception;
//    List<User> getByAllUser()throws Exception;
//    void deleteUser(Long id)throws Exception;
    User registration(UserCreateDto dto);
    Optional<User> findByUsername(String username);
    String login(UserCreateDto dto);
}
