package com.instagram.service;

import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;


public interface UserService {

    User createUser(UserCreateRequestDto request);

}
