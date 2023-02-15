package com.example.foodapp.impl;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.FilesService;
import com.example.foodapp.services.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class IngredientServiceImpl implements IngredientService {
    private static long lastId = 1;
    private  final Map<Long,Ingredient> ingredients = new TreeMap<>();
    private final FilesService filesService;
    public IngredientServiceImpl(FilesService fileService) {
        this.filesService = fileService;
    }
    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public long addIngredient(Ingredient ingredient) {

        ingredients.put(lastId, ingredient);
        saveToFile();
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
        if (ingredients.containsKey(id)) {
            ingredients.put(id, ingredient);
            saveToFile();
            return ingredient;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteIngredient(long id) {
            if (ingredients.containsKey(id)) {
                ingredients.remove(id);
                saveToFile();
                return true;
            }

        return false;
    }
    private void saveToFile(){
        try{
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    private void readFromFile()  {
        String json = filesService.reedFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    }

