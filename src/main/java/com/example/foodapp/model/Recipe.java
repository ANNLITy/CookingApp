package com.example.foodapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private String unitOfTime;
    private int time;
    private int portions;
    private List<Ingredient> ingredients;
    private String[] steps;
}