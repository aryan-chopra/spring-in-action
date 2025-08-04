package com.example.taco_cloud_auth_server.repository;

import com.example.taco_cloud_auth_server.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
