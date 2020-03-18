package com.realmeapi.repository;

import com.realmeapi.document.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepo() {

        User user = new User();
        user.setUsername("LJ");
        user.setPassword("wtf");

        this.userRepository.save(user);

        List<User> users = this.userRepository.findAll();
        assert users.get(0).getUsername().equals("LJ");

        User result = this.userRepository.findByUsername("LJ");
        assert result.getUsername().equals("LJ");

//        this.userRepository.deleteAll();
//        users = this.userRepository.findAll();
//        assert users.size() == 0;
    }
}
