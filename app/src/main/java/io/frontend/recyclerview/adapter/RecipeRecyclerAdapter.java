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
import me.zhanghai.android.materialratingbar.MaterialRatingBar;


public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeRecyclerAdapter.MyViewHolder> {

    private List<Recipe> recipeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public MaterialRatingBar mrb;

        public MyViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.recipe_item_title);
            mrb =  view.findViewById(R.id.rb_recipe_item);
        }
    }


    public RecipeRecyclerAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
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
        holder.mrb.setProgress(9);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}