package com.example.foodapp.impl;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.FilesService;
import com.example.foodapp.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Service
public class RecipeServiceImpl implements RecipeService {
    private Map<Integer, Recipe> recipes = new HashMap<>();
    private static int id = 1;

    private final FilesService fileService;

    @Value("${name.of.data.recipe.file}")
    private String dataFileName;

    public RecipeServiceImpl(FilesService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public int add(Recipe recipe) {
        recipes.put(id, recipe);
        saveFile();
        return id++;
    }

    @Override
    public Recipe get(int id) {
        return recipes.get(id);
    }

    @Override
    public List<Recipe> getAll() {
        return recipes.values().stream().toList();
    }

    @Override
    public Recipe edit(int id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            saveFile();
            return recipe;
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        if(recipes.containsKey(id)) {
            recipes.remove(id);
            saveFile();
            return true;
        }
        return false;
    }

    private void saveFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            fileService.saveToFile(json, dataFileName);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try {
            String json = fileService.reedFromFile(dataFileName);
            if (StringUtils.isBlank(json)) {
                recipes = new HashMap<>();
            } else {
                recipes = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Recipe>>() {
                });
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

