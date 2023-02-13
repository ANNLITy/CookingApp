package com.example.foodapp.controllers;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.StringValueExp;
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
    @Operation(
            summary = "Добавить рецепт",
            description= "Ввод названия,ингредиентов,способа приготовления"
    )

    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe){
        long id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Получить рецепт",
            description= "Необходимо ввести id рецепта"
    )
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id){
        Recipe recipe =recipeService.getRecipe(id);
        if(recipe==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    @GetMapping("/")
    @Operation(
            summary = "Получить все рецепты",
            description= "Вывод списка всех рецептов"
    )
    public ResponseEntity<List<Recipe>> getAllRecipes(){
            List<Recipe> recipes = recipeService.getAllRecipes();
            return  ResponseEntity.ok(recipes);
        }
    @PutMapping("/{id}")
    @Operation(
            summary = "Изменить рецепт",
            description= "Редактирование рецепта"
    )
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id,@RequestBody Recipe recipe) {
        Recipe recipe1 = recipeService.editRecipe(id,recipe);
        if (recipe1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe1);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить рецепт",
            description= "Удаление рецепта из списка"
    )
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id){
        if(recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}



