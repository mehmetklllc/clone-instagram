package com.instagram.dto;


import lombok.Data;

@Data
public class UserCreateRequestDto {
    private String username;
    private String displayName;
    private String password;
}
