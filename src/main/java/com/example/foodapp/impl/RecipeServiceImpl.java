package com.example.foodapp.impl;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.FilesService;
import com.example.foodapp.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Service
public class RecipeServiceImpl implements RecipeService {
private static long lastId = 1;
    private final   Map<Long, Recipe> recipes = new TreeMap<>();
    private final FilesService filesService;

    @Value("${name.of.data.recipe.file}")
    private String dataFileName;
    public RecipeServiceImpl(FilesService fileService) {
        this.filesService = fileService;
    }
    @PostConstruct
    private void init() {
        readFromFile();
    }
    @Override
    public long addRecipe(Recipe recipe) {

        recipes.put(lastId, recipe);
        saveToFile();
        return lastId++;
    }

    @Override
    public Recipe getRecipe(long id) {
        return recipes.get(id);
    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        if(recipes.containsKey(id)) {
            recipes.put(id, recipe);
            saveToFile();
            return recipe;
        } else{
            return null;
        }
    }
    @Override
    public List<Recipe> getAllRecipes() {
        return recipes.values().stream().toList();
    }
    @Override
    public Recipe get(long id) {
        return recipes.get(id);
    }



    @Override
    public boolean deleteRecipe(long id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            saveToFile();
            return true;
        }

        return false;
    }
    private void saveToFile(){
        try{
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    private void readFromFile()  {
        String json = filesService.reedFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}


