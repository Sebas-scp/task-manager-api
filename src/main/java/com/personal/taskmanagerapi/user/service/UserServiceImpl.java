package com.personal.taskmanagerapi.user.service;

import com.personal.taskmanagerapi.user.User;
import com.personal.taskmanagerapi.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.personal.taskmanagerapi.user.dto.UserResponse;
import com.personal.taskmanagerapi.user.dto.UserCreateRequest;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        User user = new User();

        //Data went through UserCreateRequest validations
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User saved = userRepository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()))
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        //Fetch the user from DB, if not found, throw exception
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        //The user returned from the DB is then passed through user response
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
