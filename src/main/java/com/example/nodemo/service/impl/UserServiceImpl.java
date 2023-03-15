package com.example.nodemo.service.impl;

import com.example.nodemo.controller.dto.UserCreateDto;
import com.example.nodemo.model.User;
import com.example.nodemo.repository.UserRepository;
import com.example.nodemo.service.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserInterface {
    private final UserRepository userRepository;
    @Override
    public User createUser(UserCreateDto createDto) throws Exception {
        User user = new User();
        user.setUsername(createDto.getUsername());
        if(isValidPassword(createDto.getPassword())==true)
        {
            user.setPassword(createDto.getPassword());
        }
        else{

        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserCreateDto createDto) throws Exception {
    User user = userRepository.findById(id).orElseThrow();
    user.setUsername(createDto.getUsername());
    if(isValidPassword(createDto.getPassword())==true)
    {
        user.setPassword(createDto.getPassword());
    }

    return userRepository.save(user);
    }
    private Boolean isValidPassword(String password)
    {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex

        return m.matches();
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
