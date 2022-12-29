package com.instagram.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequestDto {

    @NotNull(message = "Username cannot be null!")
    @Size(min = 3,max = 10,message = "Username can be min 3 max 10 characters!")
    private String username;
    @NotNull(message = "DisplayName cannot be null!")
    private String displayName;
    @NotNull(message = "Password cannot be null!")
    private String password;
}
