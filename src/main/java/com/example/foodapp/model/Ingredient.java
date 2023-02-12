package com.example.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
@Data
public class Ingredient {
    private String name;
    private int numberOfIngredients;
    private String measureUnit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return numberOfIngredients == that.numberOfIngredients && Objects.equals(name, that.name) && Objects.equals(measureUnit, that.measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfIngredients, measureUnit);
    }
}
