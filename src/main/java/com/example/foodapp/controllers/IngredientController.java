package com.example.foodapp.controllers;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ingredient")
@RestController
public class IngredientController {
    private final   IngredientService ingredientService;
    public IngredientController(IngredientService ingredientService){
        this.ingredientService = (IngredientService) ingredientService;
    }
    @PostMapping("/")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient){
        Ingredient newIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(newIngredient);
    }
    @GetMapping("/")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam int id){
        Ingredient ingredient =ingredientService.getIngredient(id);
        if(ingredient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }


}
