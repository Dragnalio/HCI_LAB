package com.lab.hciapp;

import java.util.Vector;

public class Recipe {

    public static Vector<Recipe> recipes = new Vector<>();
    public static Recipe recipe;

    private String name, description, instructions;
    private int image;

    public Recipe(String name, String description, String instructions, int image) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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
