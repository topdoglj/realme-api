package com.realmeapi.controller;

import com.realmeapi.document.user.User;
import com.realmeapi.manager.UserManager;
import com.realmeapi.model.AuthenticationRequest;
import com.realmeapi.model.RegistrationRequest;
import com.realmeapi.service.AuthenticationTokenUtils;
import com.realmeapi.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private AuthenticationTokenUtils authenticationTokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserManager userManager;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword());

        userManager.add(user);

        return authenticationTokenUtils.generateToken(registrationRequest.getUsername());
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }

        return authenticationTokenUtils.generateToken(authenticationRequest.getUsername());
    }

    @GetMapping("/handshake")
    public String handshake() {
        return "Shake Hands";
    }
}
