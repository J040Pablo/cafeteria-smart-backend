package com.smartcafe.smartcafe.controller;

import com.smartcafe.smartcafe.dto.LoginRequestDTO;
import com.smartcafe.smartcafe.dto.RegisterRequestDTO;
import com.smartcafe.smartcafe.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDTO dto) {
        authService.register(dto);
        return "Usuário criado com sucesso";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
        return authService.login(dto);
    }
}

