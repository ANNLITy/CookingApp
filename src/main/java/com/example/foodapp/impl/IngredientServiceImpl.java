package com.example.foodapp.impl;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class IngredientServiceImpl implements IngredientService {
    private static int id = 1;
    private final Map<Integer, Ingredient> ingredients = new TreeMap<>();
    @Override
    public Ingredient addIngredient(Ingredient ingredient ) {
        ingredients.put(id++,ingredient);

        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
       return ingredients.get(id);
    }
}
