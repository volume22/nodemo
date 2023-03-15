package com.example.nodemo.service.impl;

import com.example.nodemo.controller.dto.UserCreateDto;
import com.example.nodemo.model.User;
import com.example.nodemo.repository.UserRepository;
import com.example.nodemo.service.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserInterface {
    private final UserRepository userRepository;
    @Override
    public User createUser(UserCreateDto createDto) throws Exception {
        User user = new User();
        user.setUsername(createDto.getUsername());
        user.setPassword(createDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserCreateDto createDto) throws Exception {
    User user = userRepository.findById(id).orElseThrow();
    user.setUsername(createDto.getUsername());
    user.setPassword(createDto.getPassword());
    return userRepository.save(user);
    }

    @Override
    public List<User> getByAllUser() throws Exception {
        return userRepository.findAll().stream().toList();
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userRepository.deleteById(id);
    }
}
