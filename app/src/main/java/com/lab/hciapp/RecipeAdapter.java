package com.lab.hciapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    Context context;
    Vector<Recipe> recipes;
    OnClick onClick;

    public RecipeAdapter(Context context, Vector<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);

        // Glide
        holder.ivImage.setImageResource(recipe.getImage());
        holder.tvName.setText(recipe.getName());
        holder.tvDescription.setText(recipe.getDescription());
    }

    @Override
    public int getItemCount() {
        return Recipe.recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName;
        TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.recipe_iv_image);
            tvName = itemView.findViewById(R.id.recipe_tv_name);
            tvDescription = itemView.findViewById(R.id.recipe_tv_description);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (onClick != null && position != RecyclerView.NO_POSITION) {
                    onClick.onClick(Recipe.recipes.get(position));
                }
            });
        }
    }

    public interface OnClick{
        void onClick(Recipe recipe);
    }

}
