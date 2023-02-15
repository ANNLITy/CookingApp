package com.example.foodapp.services;

import com.example.foodapp.model.Recipe;

import java.util.List;

public interface RecipeService {
    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    Recipe editRecipe(long id, Recipe recipe);

    List getAllRecipes();

    boolean deleteRecipe(long id);


    Recipe get(long id);;


}
