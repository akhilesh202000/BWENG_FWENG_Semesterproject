package com.example.RESTAPI.Controller;

import com.example.RESTAPI.Entity.User;
import com.example.RESTAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
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

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        try {
            //User user = userRepository.findByUsername(username);
            User tmp = null;
            List<User> userList = (List<User>) userRepository.findAll();
            for (User user : userList
            ) {
                if (user.getUsername().equals(username))
                    tmp = user;
            }
            if (tmp != null)
                return new ResponseEntity<User>(tmp, HttpStatus.OK);
            else return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
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
    @DeleteMapping("/users/{username}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String username) {
        try {
           User tmp = null;
            List<User> userList = (List<User>) userRepository.findAll();
            for (User user : userList
            ) {
                if (user.getUsername().equals(username))
                    tmp = user;
            }
            if (tmp!=null){
                userRepository.delete(tmp);
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PatchMapping("/users/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User userDetails) {
        try {
            User tmp = null;
            List<User> userList = (List<User>) userRepository.findAll();
            for (User user : userList
            ) {
                if (user.getUsername().equals(username))
                    tmp = user;
            }
            if (tmp != null) {
                tmp.setUsername(userDetails.getUsername());
                tmp.setPassword(userDetails.getPassword());
                tmp.setRole(userDetails.getRole());
                return new ResponseEntity<User>(userRepository.save(tmp), HttpStatus.OK);
            } else return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}