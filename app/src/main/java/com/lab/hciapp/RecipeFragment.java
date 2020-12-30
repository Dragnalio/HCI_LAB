package com.lab.hciapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

public class RecipeFragment extends Fragment {

    RecipeAdapter recipeAdapter;
    RecyclerView recyclerView;

    public RecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Recipe.addRecipe(new Recipe("Cake", "a", R.drawable.image1));
        Recipe.addRecipe(new Recipe("Softcake", "b", R.drawable.image2));
        Recipe.addRecipe(new Recipe("Bread", "c", R.drawable.image3));
        Recipe.addRecipe(new Recipe("Pudding", "d", R.drawable.image4));

        // RecyclerView
        recipeAdapter = new RecipeAdapter(getContext(), Recipe.recipes);
        recyclerView = view.findViewById(R.id.recipe_rv_list);
        recyclerView.setAdapter(recipeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }
}