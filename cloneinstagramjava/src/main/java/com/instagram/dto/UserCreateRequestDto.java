package com.instagram.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import static com.instagram.dto.InsConstans.*;

@Data
public class UserCreateRequestDto {
    @NotNull(message = USERNAME_NOT_NULL)
    @NotEmpty(message = USERNAME_NOT_NULL)
    @NotBlank(message = USERNAME_NOT_NULL)
    private String username;

    private String displayName;

    private String password;
}
