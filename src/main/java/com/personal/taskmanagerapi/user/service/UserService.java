package com.personal.taskmanagerapi.user.service;

import com.personal.taskmanagerapi.user.User;
import com.personal.taskmanagerapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        //Revisamos si ya existe el correo, si no existe, lo guardamos
        if(userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email already in use");
        }
        return userRepository.save(user);
    }

    //Lista de todos los usuarios
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Buscar usuario por id
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
