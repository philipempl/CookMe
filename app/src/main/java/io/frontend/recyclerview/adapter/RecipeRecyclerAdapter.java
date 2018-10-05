package io.frontend.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.philip.vibs.R;

import java.util.List;

import io.frontend.dataholder.DataHolder;
import io.frontend.model.Recipe;


public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeRecyclerAdapter.MyViewHolder> {

    private List<Recipe> recipeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView food;
        public TextView title, description;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.recipe_item_title);
            description = (TextView) view.findViewById(R.id.recipe_item_description);
        }
    }


    public RecipeRecyclerAdapter() {
        this.recipeList = DataHolder.recipeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.title.setText(recipe.getTitle());
        holder.description.setText(recipe.getDescription());

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}