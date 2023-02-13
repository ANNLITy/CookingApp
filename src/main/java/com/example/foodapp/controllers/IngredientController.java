package com.example.foodapp.controllers;
import com.example.foodapp.model.Ingredient;
import com.example.foodapp.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/ingredient")
@RestController
@Tag(name = "Ингредиенты", description = "Добавление,изменение,удаление и просмотр ингредиентов")
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
        Ingredient ingredient = ingredientService.getIngredient(id);
        if(ingredient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
    @GetMapping("/")

    public ResponseEntity<List<Ingredient>> getAllIngredients(){
         List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
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
