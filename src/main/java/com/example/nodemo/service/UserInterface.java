package com.example.nodemo.service;

import com.example.nodemo.controller.dto.UserCreateDto;
import com.example.nodemo.model.User;

import java.util.List;

public interface UserInterface {
    User createUser(UserCreateDto createDto)throws Exception;
    User updateUser(Long id,UserCreateDto createDto)throws Exception;
    List<User> getByAllUser()throws Exception;
    void deleteUser(Long id)throws Exception;
}
