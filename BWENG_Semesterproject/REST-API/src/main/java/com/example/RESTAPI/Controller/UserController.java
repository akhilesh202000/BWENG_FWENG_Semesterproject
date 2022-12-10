package com.example.RESTAPI.Controller;

import com.example.RESTAPI.Entity.User;
import com.example.RESTAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   /* @CrossOrigin
    @GetMapping("/users")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/users")
    public User addUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }*/
    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        try {
            List<User> list = (List<User>) userRepository.findAll();
            if (list.isEmpty()) {
                return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        try {
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            user.ifPresent(userRepository::delete);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            User user = userRepository.findById(id).get();
            user.setUsername(userDetails.getUsername());
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}