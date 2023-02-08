package com.example.foodapp.controllers;

import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/recipe")
@RestController
public class RecipeController {
    private final  RecipeService recipeService;
    public  RecipeController(RecipeService recipeService){
        this.recipeService = (RecipeService) recipeService;
    }
    @PostMapping("/")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(newRecipe);
    }
    @GetMapping("/")
    public ResponseEntity<Recipe> getRecipe(@RequestParam int id){
    Recipe recipe =recipeService.getRecipe(id);

    if(recipe==null){
        return ResponseEntity.notFound().build();
    }
        return ResponseEntity.ok(recipe);
    }


}
