package com.example.springsecurityauthserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MessageController {

    @GetMapping("/user/principal")
    public Principal user(Principal principal) {
        return principal;
    }
}
