package com.example.foodapp.services;

import com.example.foodapp.model.Recipe;

import java.nio.file.Path;
import java.util.List;

public interface RecipeService {
    int add(Recipe recipe);

    Recipe get(int id);

    List<Recipe> getAll();

    Recipe edit(int id, Recipe recipe);

    boolean delete(int id);

    Path createCurrentRecipesFile();
}