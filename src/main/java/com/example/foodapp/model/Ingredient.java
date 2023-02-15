package com.example.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {
    private String name;
    private int numberOfIngredients;
    private String measureUnit;


}


