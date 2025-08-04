package com.example.taco_cloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/ingredients")
                            .hasAuthority("SCOPE_writeIngredients")
                        .requestMatchers(HttpMethod.DELETE, "/api/ingredients")
                            .hasAuthority("SCOPE_deleteIngredients")
                        .requestMatchers("/design", "/orders", "/secure-test")
                            .hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/", "/**").permitAll()
                        .requestMatchers(toH2Console()).permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console())
                        .disable()
                )
                .formLogin(loginPage -> loginPage
                        .loginPage("/login")
                        .defaultSuccessUrl("/design")
                )
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .logout(logout -> logout
                        .logoutUrl("/logout"))
                .sessionManagement(sessions -> sessions
                        .requireExplicitAuthenticationStrategy(false))
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults()))
                .build();
    }
}
