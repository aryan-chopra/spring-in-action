package com.example.taco_cloud.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min = 5, message = "Name should be atleast 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "At least one ingredient is required")
    private List<Ingredient> ingredients;
}
