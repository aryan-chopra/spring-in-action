package com.example.taco_cloud_auth_server.config;

import com.example.taco_cloud_auth_server.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception{
        return http
                .authorizeHttpRequests(
                        authourizeHttpRequests -> authourizeHttpRequests
                                .requestMatchers("/login").permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .getOrBuild();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository) {
        return userRepository::findByUsername;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
