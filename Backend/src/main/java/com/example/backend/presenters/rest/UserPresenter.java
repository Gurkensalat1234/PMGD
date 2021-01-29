package com.example.backend.presenters.rest;

import com.example.backend.entities.User;
import com.example.backend.general.HttpConstants;
import com.example.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(HttpConstants.REST_API_USER_ENDPOINT)
public class UserPresenter {


    private UserRepository userRepository;

    @Autowired
    public UserPresenter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);

    }

    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(User.builder().id(-1).username("Mock user").build());
    }
}
