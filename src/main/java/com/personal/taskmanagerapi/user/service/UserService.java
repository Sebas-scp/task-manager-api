package com.personal.taskmanagerapi.user.service;

import com.personal.taskmanagerapi.user.dto.UserResponse;
import com.personal.taskmanagerapi.user.dto.UserCreateRequest;

import java.util.List;

public interface UserService{
    UserResponse createUser(UserCreateRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
}