package com.example.foodapp.services;

import com.example.foodapp.model.Recipe;

public interface RecipeService {
    Recipe addRecipe(Recipe recipe);
    Recipe getRecipe(int id);
}
