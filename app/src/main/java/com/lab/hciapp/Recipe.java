package com.lab.hciapp;

import java.util.Vector;

public class Recipe {

    public static Vector<Recipe> recipes = new Vector<>();
    public static int recipeIndex = -1;

    private String name, description;
    private int image;

    public Recipe(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
