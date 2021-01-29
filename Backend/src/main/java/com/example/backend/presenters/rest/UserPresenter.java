package com.example.backend.presenters.rest;

import com.example.backend.entities.User;
import com.example.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/db")
public class UserPresenter {

    @Autowired
    private UserRepository repository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }
}
