package com.example.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@AllArgsConstructor
@Data

public class Recipe {
    private String name;
    private int cookingTime;
    ArrayList<Ingredient> Ingredients;
    ArrayList<String> cookingSteps;

}
