package com.instagram.dto;


import com.instagram.modal.InsResultMessage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequestDto {

    @NotNull(message = InsResultMessage.USERNAME_NOTNULL_ERROR_MESSAGE)
    @Size(min = 3, max = 10, message = InsResultMessage.USERNAME_SIZE_ERROR_MESSAGE)
    private String username;
    @NotNull(message = InsResultMessage.DISPLAY_NAME_NOTNULL_ERROR_MESSAGE)
    private String displayName;
    @NotNull(message = InsResultMessage.PASSWORD_NOTNULL_ERROR_MESSAGE)
    private String password;
}
