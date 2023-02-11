package com.example.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Ingredient {
    private String name;
    private int numberOfIngredients;
    private String measureUnit;

    }
