package com.example.foodapp.impl;

import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;

import java.util.Map;
import java.util.TreeMap;

public class RecipeServiceImpl implements RecipeService {
private static int id = 1;
    private static Map<Integer, Recipe> recipes = new TreeMap<>();
    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(id++,recipe);

        return recipe;
    }

    @Override
    public Recipe getRecipe(int id) {
        recipes.get(id);

        return null;
    }
}
