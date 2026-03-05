package com.personal.taskmanagerapi.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    private long id;
    private String name;
    private String email;
}
