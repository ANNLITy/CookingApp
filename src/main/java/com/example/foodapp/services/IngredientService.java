package com.example.foodapp.services;

import com.example.foodapp.model.Ingredient;

import java.util.List;

public interface IngredientService {

    long addIngredient(Ingredient Ingredient);

    Ingredient getIngredient(long lastId);

    List<Ingredient> getAllIngredients();

    Ingredient editIngredient(long id, Ingredient ingredient);

    boolean deleteIngredient(long id);


}
