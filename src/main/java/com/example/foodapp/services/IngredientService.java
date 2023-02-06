package com.example.foodapp.services;

import com.example.foodapp.model.Ingredient;


public interface IngredientService {
    Ingredient addIngredient(Ingredient Ingredient);
    Ingredient getIngredient(int id);
}
