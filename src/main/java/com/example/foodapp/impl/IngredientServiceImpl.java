package com.example.foodapp.impl;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.FilesService;
import com.example.foodapp.services.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class IngredientServiceImpl implements IngredientService {
    private Map<Integer, Ingredient> ingredients = new HashMap<>();

    private final FilesService fileService;

    private static int id = 1;

    @Value("${name.of.data.ingredients.file}")
    private String dataFileName;

    public IngredientServiceImpl(FilesService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }


    @Override
    public int add(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        saveFile();
        return id++;
    }

    @Override
    public Ingredient get(int id) {
        return ingredients.get(id);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredients.values().stream().toList();
    }

    @Override
    public Ingredient edit(int id, Ingredient ingredient) {
        if (ingredients.containsKey(id)) {
            ingredients.put(id, ingredient);
            saveFile();
            return ingredient;
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            saveFile();
            return true;
        }
        return false;
    }


    private void saveFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            fileService.saveToFile(json, dataFileName);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try {
            String json = fileService.reedFromFile(dataFileName);
            if (StringUtils.isBlank(json)) {
                ingredients = new HashMap<>();
            } else {
                ingredients = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingredient>>() {
                });
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

