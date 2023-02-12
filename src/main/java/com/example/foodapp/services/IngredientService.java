package com.example.foodapp.services;

import com.example.foodapp.model.Ingredient;

public interface IngredientService {

    long addIngredient(Ingredient Ingredient);

    Ingredient getIngredient(long lastId);

    String getAllIngredients();

    Ingredient editIngredient(long id, Ingredient ingredient);

    boolean deleteIngredient(long id);
}
