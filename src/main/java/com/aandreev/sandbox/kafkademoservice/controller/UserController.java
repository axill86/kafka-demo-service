package com.aandreev.sandbox.kafkademoservice.controller;

import com.aandreev.sandbox.kafkademoservice.service.UserService;
import example.avro.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User u) {
        userService.createUser(u);
        return ResponseEntity.ok("Success");
    }
}
