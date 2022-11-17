package com.example.RESTAPI.Repository;

import com.example.RESTAPI.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
