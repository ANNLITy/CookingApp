package com.example.foodapp.controllers;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/recipe")
@RestController
@Tag(name = "Рецепты", description = "Добавление,изменение,удаление и просмотр рецептов")
public class RecipeController {
    private final  RecipeService recipeService;
    public  RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
    @PostMapping("/")


    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe){
        long id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")

    public ResponseEntity<Recipe> getRecipe(@PathVariable long id){
        Recipe recipe =recipeService.getRecipe(id);
        if(recipe==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    @GetMapping("/")

    public ResponseEntity<List<Recipe>> getAllRecipes(){
           List<Recipe> recipes = recipeService.getAllRecipes();
            return  ResponseEntity.ok(recipes);
        }
    @PutMapping("/{id}")

    public ResponseEntity<Recipe> editRecipe(@PathVariable long id,@RequestBody Recipe recipe) {
        Recipe recipe1 = recipeService.editRecipe(id,recipe);
        if (recipe1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe1);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteRecipe(@PathVariable long id){
        if(recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}



