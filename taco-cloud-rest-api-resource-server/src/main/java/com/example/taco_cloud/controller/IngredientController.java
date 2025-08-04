package com.example.taco_cloud.controller;

import com.example.taco_cloud.domain.Ingredient;
import com.example.taco_cloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/ingredients")
public class IngredientController {

    private IngredientRepository repository;

    @Autowired
    public IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Ingredient> getAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveIngredient(
            @RequestBody Ingredient ingredient
    ) {
        return repository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(
            @PathVariable String id
    ) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ignore) {}
    }
}
