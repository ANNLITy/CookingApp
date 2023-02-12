package com.example.foodapp.services;

import com.example.foodapp.model.Recipe;

public interface RecipeService {
    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    Recipe editRecipe(long id, Recipe recipe);

    String getAllRecipes();

    boolean deleteRecipe(long id);
}
