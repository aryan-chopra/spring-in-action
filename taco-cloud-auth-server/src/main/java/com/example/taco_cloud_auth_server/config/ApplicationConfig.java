package com.example.taco_cloud_auth_server.config;

import com.example.taco_cloud_auth_server.domain.User;
import com.example.taco_cloud_auth_server.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApplicationRunner dataLoader(
            UserRepository repository,
            PasswordEncoder encoder
    ) {
        return args -> {
            repository.save(
                    new User("Rick", encoder.encode("wabalabadubdub"), "ROLE_ADMIN")
            );

            repository.save(
                    new User("Morty", encoder.encode("AwwJeez"), "ROLE_USER")
            );
        };
    }
}
