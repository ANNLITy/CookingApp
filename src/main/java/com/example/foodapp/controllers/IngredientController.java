package com.example.foodapp.controllers;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ingredient")
@RestController
public class IngredientController {
    private final   IngredientService ingredientService;
    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }
    @PostMapping("/")
    public ResponseEntity<Long> addIngredient(@RequestBody Ingredient ingredient){
        long id = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable long id){
        Ingredient ingredient =ingredientService.getIngredient(id);
        if(ingredient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id,@RequestBody Ingredient ingredient) {
        Ingredient ingredient1 = ingredientService.editIngredient(id,ingredient);
        if (ingredient1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long id){
        if(ingredientService.deleteIngredient(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
