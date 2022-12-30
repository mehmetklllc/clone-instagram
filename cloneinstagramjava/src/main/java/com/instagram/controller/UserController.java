package com.instagram.controller;

import com.instagram.config.LocalizationResolver;
import com.instagram.dto.InsResponseEntity;
import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import com.instagram.modal.InsResultMessage;
import com.instagram.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    LocalizationResolver localizationResolver;

    @PostMapping("/api/create-user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserCreateRequestDto request) {

        User user = userService.createUser(request);
        log.info(request.toString());
        return InsResponseEntity.response("success", HttpStatus.CREATED, user);
    }

    @GetMapping("/api/test")
    public String test() {
        return localizationResolver.resolve(InsResultMessage.USERNAME_NOTNULL_ERROR_MESSAGE);
    }
}
