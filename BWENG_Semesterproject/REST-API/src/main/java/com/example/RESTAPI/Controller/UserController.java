package com.example.RESTAPI.Controller;

import com.example.RESTAPI.Entity.User;
import com.example.RESTAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @GetMapping("/users")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/users")
    public User addUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }
}
