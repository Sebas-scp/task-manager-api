package com.personal.taskmanagerapi.user.controller;

import com.personal.taskmanagerapi.user.dto.UserCreateRequest;
import com.personal.taskmanagerapi.user.dto.UserResponse;
import com.personal.taskmanagerapi.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse createUser(
            @Valid @RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
