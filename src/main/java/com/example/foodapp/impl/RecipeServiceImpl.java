package com.example.foodapp.impl;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class RecipeServiceImpl implements RecipeService {
private static int id = 1;
    private final Map<Integer, Recipe> recipes = new TreeMap<>();
    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(id++,recipe);

        return recipe;
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipes.get(id);
    }
}
