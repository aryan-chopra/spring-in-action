package com.example.taco_cloud.configuration;

import com.example.taco_cloud.domain.Ingredient;
import com.example.taco_cloud.domain.User;
import com.example.taco_cloud.repository.IngredientRepository;
import com.example.taco_cloud.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo,
                                        UserRepository userRepository,
                                        PasswordEncoder encoder) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

            User user = new User(
                    "someone", encoder.encode("12345") ,
                    "Aryan Chopra", "none", "none", "none",
                    "123456", "1234567890"
            );
            user.addRole("USER");
            userRepository.save(user);

            User admin = new User(
                    "admin", encoder.encode("admin") ,
                    "Aryan Chopra", "none", "none", "none",
                    "123456", "1234567890"
            );
            admin.addRole("ADMIN");
            userRepository.save(admin);
        };
    }
}
