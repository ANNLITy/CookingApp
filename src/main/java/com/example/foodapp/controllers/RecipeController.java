package com.example.foodapp.controllers;

import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/recipe")
@RestController
public class RecipeController {
    private  RecipeService recipeService;
    public RecipeController(RecipeController recipeController){
        this.recipeService = recipeService;
    }
    @PostMapping
    public ResponseEntity addRecipe(@RequestBody Recipe recipe){
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(newRecipe);
    }
    @GetMapping
    public ResponseEntity getRecipe(@PathVariable int id){
    Recipe recipe =recipeService.getRecipe(id);
    if(recipe==null){
        return ResponseEntity.notFound().build();
    }
        return ResponseEntity.ok(recipe);
    }

}
