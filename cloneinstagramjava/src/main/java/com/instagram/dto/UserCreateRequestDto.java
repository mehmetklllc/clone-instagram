package com.instagram.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateRequestDto {

    @NotNull(message = "test not null")
    private String username;

    private String displayName;

    private String password;
}
