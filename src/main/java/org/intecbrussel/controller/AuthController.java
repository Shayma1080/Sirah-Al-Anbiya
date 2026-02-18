package org.intecbrussel.controller;

import org.intecbrussel.dto.LoginRequest;
import org.intecbrussel.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.intecbrussel.model.User;
import org.intecbrussel.service.AuthService;
import org.intecbrussel.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final LoginService loginService;

    @PostMapping("/register")
    public User register(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password) {
        // geeft nog steeds het hele User object terug
        return authService.register(username, email, password);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        String jwt = loginService.login(request.getUsername(), request.getPassword());
        return new TokenResponse(jwt);
    }
}
