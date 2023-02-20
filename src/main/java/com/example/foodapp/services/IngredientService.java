package com.example.foodapp.services;

import com.example.foodapp.model.Ingredient;

import java.util.List;

public interface IngredientService {
    int add(Ingredient ingredient);

    Ingredient get(int id);

    List<Ingredient> getAll();

    Ingredient edit(int id, Ingredient ingredient);

    boolean delete(int id);
}