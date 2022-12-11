package com.instagram.service;

import com.instagram.dto.InsConstans;
import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import com.instagram.mapper.UserMapper;
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
        User user = UserMapper.USER_INSTANCE.userDtoToUser( reqeust );
        if(userRepository.findByUsername(user.getUsername()).isPresent())
            throw new IllegalArgumentException(InsConstans.USERNAME_MUST_BE_UNIQUE);

        user.setPassword(passwordEncoder.encode(reqeust.getPassword()));
        userRepository.save(user);
        return user;
    }
}
