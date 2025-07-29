package com.example.taco_cloud.configuration;

import com.example.taco_cloud.domain.User;
import com.example.taco_cloud.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserConfig {

    /**
     * This method builds an implementation of the "UserDetailsService" interface
     * used to load a User by their username
     * @param userRepository the userRepository used to interact with Database
     * @return UserDetailsService the implemented interface used to fetch a user from DB.
     */

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }

            throw new UsernameNotFoundException("User" + username + " not found");
        };
    }
}