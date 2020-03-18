package com.realmeapi.manager;

import com.realmeapi.document.user.User;
import com.realmeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        this.userRepository.save(user);
    }
}
