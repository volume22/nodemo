package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.controller.dto.UserCreateDto;
import com.example.nodemo.model.Order;
import com.example.nodemo.model.User;
import com.example.nodemo.repository.UserRepository;
import com.example.nodemo.service.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
private final UserInterface userInterface;
private  final UserRepository userRepository;
    @PostMapping("/api/user")
    public User createUser(@RequestBody UserCreateDto createdto) throws Exception {
        return userInterface.createUser(createdto);
    }
    @PutMapping ("/api/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserCreateDto createdto) throws Exception {
         userInterface.updateUser(id,createdto);
    }
    @GetMapping  ("/api/users")
    public List<User> getByAllUser() throws Exception {
        return userInterface.getByAllUser();
    }
    @DeleteMapping  ("/api/user/{id}")
    public void deleteUser(Long id) throws Exception {
        userInterface.deleteUser(id);
    }
}
