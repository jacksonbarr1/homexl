package com.example.homexl.controller;

import com.example.homexl.dto.UserDto;
import com.example.homexl.entity.User;
import com.example.homexl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) {
        UserDetails existingUser = userRepository.findByUsername(userDto.getUsername()).orElse(null);
        if (existingUser != null) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

}
