package com.example.taco_cloud.converter;

import com.example.taco_cloud.UDT.IngredientUDT;
import com.example.taco_cloud.domain.Ingredient;
import com.example.taco_cloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class IngredientUDTByIdConverter implements Converter<String, IngredientUDT> {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientUDTByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        return ingredientRepository.findById(id).orElse(null).toUDT();
    }
}
