package com.realmeapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
public class AuthenticationTokenUtilsTest {

    @Autowired
    private AuthenticationTokenUtils authenticationTokenUtils;

    @Test
    public void testGenerateToken() {
    }
}
