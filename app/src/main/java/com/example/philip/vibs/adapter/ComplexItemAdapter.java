package com.example.philip.vibs.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.philip.vibs.DataHolder;
import com.example.philip.vibs.R;
import com.example.philip.vibs.model.Recipe;

import java.text.SimpleDateFormat;
import java.util.List;

public class ComplexItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public class RecipeItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public ImageView food;

        public RecipeItemViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.recipe_item_title);
            description = (TextView) view.findViewById(R.id.recipe_item_description);
        }

    }
        // The items to display in your RecyclerView
    private List<Object> items;

    private final int RECIPEITEM = 0, BIRTHDAYITEM = 1, STORYITEM = 2, MULTIMEDIAITEM = 3, DOCUMENTITEM = 4;

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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

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
            rivh.description.setText(recipe.getDescription());
        }
    }
}
