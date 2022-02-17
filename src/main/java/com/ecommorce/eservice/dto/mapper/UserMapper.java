package com.ecommorce.eservice.dto.mapper;

import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.model.User;

import javax.validation.constraints.NotNull;

public class UserMapper {
    private UserMapper() {
    }

    public static UserDto toDto(@NotNull User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(@NotNull UserDto userDto) {
        return new User(userDto.getEmail(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getUsername());
    }
}
