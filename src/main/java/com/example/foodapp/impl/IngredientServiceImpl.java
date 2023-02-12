package com.example.foodapp.impl;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static long lastId = 1;
    private  final Map<Long,Ingredient> ingredients = new TreeMap<>();


    @Override
    public long addIngredient(Ingredient ingredient) {

        ingredients.put(lastId, ingredient);

        return lastId++;
    }

    @Override
    public Ingredient getIngredient(long id) {
        return ingredients.get(id);
    }

    @Override
    public String getAllIngredients() {
        String ingredient = null;
        for (Map.Entry<Long, Ingredient> entry : ingredients.entrySet()) {
            Integer key = Math.toIntExact(entry.getKey());
            String value = String.valueOf(entry.getValue());
            ingredient = key + value;
        }
        return ingredient;
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
            if (ingredients.containsKey(id)){
                ingredients.put(id,ingredient);
            }
        return null;
        }

    @Override
    public boolean deleteIngredient(long id) {
            if (ingredients.containsKey(id)) {
                ingredients.remove(id);
                return true;
            }

        return false;
    }


    }

