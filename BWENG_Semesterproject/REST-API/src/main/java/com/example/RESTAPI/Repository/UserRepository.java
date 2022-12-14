package com.example.RESTAPI.Repository;

import com.example.RESTAPI.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    //User findByUsername(String username);
}
