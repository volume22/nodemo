package com.example.nodemo.controller;

import com.example.nodemo.controller.dto.OrderCreatedto;
import com.example.nodemo.controller.dto.UserCreateDto;
import com.example.nodemo.model.Order;
import com.example.nodemo.model.User;
import com.example.nodemo.repository.UserRepository;
import com.example.nodemo.service.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
private final UserInterface userInterface;
private  final UserRepository userRepository;
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @Validated UserCreateDto dto) {
        if(userInterface.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        userInterface.registration(dto);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(userInterface.login(dto));
    }
}
