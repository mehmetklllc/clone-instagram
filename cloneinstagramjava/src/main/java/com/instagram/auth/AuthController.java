package com.instagram.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @PostMapping("/api/auth")
    void handleAuthentication() {

    }
}
