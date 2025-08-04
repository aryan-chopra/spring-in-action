package com.example.taco_cloud.repository;

import com.example.taco_cloud.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
