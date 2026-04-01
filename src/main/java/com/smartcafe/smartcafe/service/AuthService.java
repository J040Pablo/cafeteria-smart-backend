package com.smartcafe.smartcafe.service;

import com.smartcafe.smartcafe.dto.LoginRequestDTO;
import com.smartcafe.smartcafe.model.User;
import com.smartcafe.smartcafe.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getPassword().equals((dto.getPassword()))) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
