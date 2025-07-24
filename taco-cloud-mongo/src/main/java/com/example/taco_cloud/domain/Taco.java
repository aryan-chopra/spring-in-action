package com.example.taco_cloud.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name should be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "At least one ingredient is required")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
