package com.ecommorce.eservice.dto.mapper;

import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.model.User;

import javax.validation.constraints.NotNull;

public class UserMapper {
    public static UserDto toDto(@NotNull User customer) {
        return new UserDto(customer.getName(),
                               customer.getEmail(),
                               customer.getPassword(),
                               customer.getUsername());
    }

    public static User toEntity(@NotNull UserDto userDto) {
        return new User(userDto.getEmail(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getUsername());
    }

    private UserMapper(){}
}
