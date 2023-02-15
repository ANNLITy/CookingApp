package com.example.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Recipe {
    private String name;
    private int cookingTime;
    ArrayList<Ingredient> Ingredients;
    ArrayList<String> cookingSteps;

}
