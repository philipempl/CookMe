package io.frontend.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.philip.vibs.R;

import java.util.List;

import io.frontend.model.Ingredient;

public class IngredientRecyclerAdapter extends RecyclerView.Adapter<IngredientRecyclerAdapter.MyViewHolder>{

    private List<Ingredient> ingredientList;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView amount, name;

    public MyViewHolder(View view) {
        super(view);
        amount = view.findViewById(R.id.ingredient_amount);
        name = view.findViewById(R.id.ingredient_name);
    }
}

    public IngredientRecyclerAdapter(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public IngredientRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_detail_item_ingredient, parent, false);

        return new IngredientRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IngredientRecyclerAdapter.MyViewHolder holder, int position) {
        Ingredient ingredient = ingredientList.get(position);
        String ingredientString = ingredient.getQuantity()+ " " + ingredient.getFoodStuff().getUnit();
        holder.amount.setText(ingredientString);
        holder.name.setText(ingredient.getFoodStuff().getName());

    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }
}