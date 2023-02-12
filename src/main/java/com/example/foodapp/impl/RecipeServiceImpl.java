package com.example.foodapp.impl;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class RecipeServiceImpl implements RecipeService {
private static long lastId = 1;
    private final   Map<Long, Recipe> recipes = new TreeMap<>();
    @Override
    public long addRecipe(Recipe recipe) {

        recipes.put(lastId, recipe);

        return lastId++;
    }

    @Override
    public Recipe getRecipe(long id) {
        return recipes.get(id);
    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        if (recipes.containsKey(id)){
            recipes.put(id,recipe);
        }
        return null;
    }
    @Override
    public String getAllRecipes() {
        String recipe = null;
        for (Map.Entry<Long, Recipe> entry : recipes.entrySet()) {
            Integer key = Math.toIntExact(entry.getKey());
            String value = String.valueOf(entry.getValue());
            recipe = key + value;
        }
        return recipe;
    }



    @Override
    public boolean deleteRecipe(long id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            return true;
        }

        return false;
    }


}


