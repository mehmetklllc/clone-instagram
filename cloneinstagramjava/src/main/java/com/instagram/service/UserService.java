package com.instagram.service;

import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {

    public User createUser(UserCreateRequestDto request);

}
