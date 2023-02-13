package com.example.foodapp.impl;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.IngredientService;
import org.springframework.stereotype.Service;
import java.util.*;


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
    public List<Ingredient> getAllIngredients() {
        return ingredients.values().stream().toList();
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

