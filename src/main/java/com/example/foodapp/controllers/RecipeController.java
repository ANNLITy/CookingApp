package com.example.foodapp.controllers;
import com.example.foodapp.model.Recipe;
import com.example.foodapp.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.ObjectUtils;
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
    @ApiResponse(
            responseCode = "200",
            description = "рецепт был добавлен"
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "рецепт найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "рецепт не был найден"
            )
    }
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
            description= "Вывод всех рецептов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "выведены все рецепты",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }
            )
    }
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "рецепт был изменён"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "рецепт не был найден"
            )
    }
    )
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id,@RequestBody Recipe recipe) {
        if (ObjectUtils.isNotEmpty(recipeService.get(id))) {
            recipeService.editRecipe(id, recipe);
            return ResponseEntity.ok(recipe);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить рецепт",
            description= "Удаление рецепта из списка"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "рецепт был удалён"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "рецепт не был найден"
            )
    }
    )
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id){
        if(recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}



