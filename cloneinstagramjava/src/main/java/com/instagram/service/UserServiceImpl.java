package com.instagram.service;

import com.instagram.dto.InsConstans;
import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import com.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User createUser(UserCreateRequestDto reqeust) {

        if(userRepository.findByUsername(reqeust.getUsername()).isPresent())
            throw new IllegalArgumentException(InsConstans.USERNAME_MUST_BE_UNIQUE);

        User user = new User();
        user.setUsername(reqeust.getUsername());
        user.setDisplayName(reqeust.getDisplayName());
        user.setPassword(passwordEncoder.encode(reqeust.getPassword()));
        userRepository.save(user);
        return user;
    }
}
