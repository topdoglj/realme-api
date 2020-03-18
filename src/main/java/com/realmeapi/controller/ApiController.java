package com.realmeapi.controller;

import com.realmeapi.model.AuthenticationRequest;
import com.realmeapi.service.AuthenticationTokenUtils;
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
