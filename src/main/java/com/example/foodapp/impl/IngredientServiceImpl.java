package com.example.foodapp.impl;

import com.example.foodapp.model.Ingredient;

import com.example.foodapp.services.IngredientService;

import java.util.Map;
import java.util.TreeMap;

public class IngredientServiceImpl implements IngredientService {
    private static int id = 1;
    private static Map<Integer, Ingredient> ingredients = new TreeMap<>();
    @Override
    public Ingredient addIngredient(Ingredient ingredient ) {
        ingredients.put(id++,ingredient);

        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
        ingredients.get(id);

        return null;
    }
}
