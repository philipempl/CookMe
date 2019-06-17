package io.frontend.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.philip.vibs.R;

import java.util.List;

import io.frontend.dataholder.DataHolder;
import io.frontend.model.Recipe;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class ComplexItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public class RecipeItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        MaterialRatingBar mrb;


        private RecipeItemViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.recipe_item_title);
            mrb = view.findViewById(R.id.rb_recipe_item);
        }

    }
        // The items to display in your RecyclerView
    private List<Object> items;

    private final int RECIPEITEM = 0;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ComplexItemAdapter() {
        this.items = DataHolder.feedObjectList;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Recipe) {
            return RECIPEITEM;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case RECIPEITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
                return new RecipeItemViewHolder(view);
            default:
                break;
        }
        return null;
    }

    /**
     * This method internally calls onBindViewHolder(ViewHolder, int) to update the
     * RecyclerView.ViewHolder contents with the item at the given position
     * and also sets up some private fields to be used by RecyclerView.
     *
     * @param viewHolder The type of RecyclerView.ViewHolder to populate
     * @param position Item position in the viewgroup.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case RECIPEITEM:
                RecipeItemViewHolder recipeItemViewHolder = (RecipeItemViewHolder) viewHolder;
                configureViewHolderRecipeItem(recipeItemViewHolder, position);
                break;
            default:
                break;
        }
    }

    private void configureViewHolderRecipeItem(ComplexItemAdapter.RecipeItemViewHolder rivh, int position) {
        Recipe recipe = (Recipe) items.get(position);
        if (recipe != null) {
            rivh.title.setText(recipe.getTitle());
            rivh.mrb.setProgress(9);
        }
    }
}
