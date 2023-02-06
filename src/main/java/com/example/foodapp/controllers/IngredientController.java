package com.example.foodapp.controllers;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Ingredient")
@RestController
public class IngredientController {
    private IngredientService ingredientService;
    public IngredientController(RecipeController recipeController){
        this.ingredientService = ingredientService;
    }
    @PostMapping
    public ResponseEntity addIngredient(@RequestBody Ingredient ingredient){
        Ingredient newIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(newIngredient);
    }
    @GetMapping
    public ResponseEntity getIngredient(@PathVariable int id){
        Ingredient ingredient =ingredientService.getIngredient(id);
        if(ingredient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

}
