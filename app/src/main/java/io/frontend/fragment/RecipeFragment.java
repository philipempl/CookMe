package io.frontend.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.philip.vibs.R;

import java.io.Serializable;
import java.util.List;

import io.frontend.activity.RecipeDetailActivity;
import io.frontend.dataholder.DataHolder;
import io.frontend.model.Recipe;
import io.frontend.recyclerview.adapter.ComplexItemAdapter;
import io.frontend.recyclerview.adapter.RecipeRecyclerAdapter;
import io.frontend.recyclerview.onClickListener.RecyclerFeedItemClickListener;
import jp.wasabeef.blurry.Blurry;

public class RecipeFragment extends android.support.v4.app.Fragment {

    public static boolean blurry = false;

    private RecyclerView rvRecommendedRecipes, rvPopularRecipes, rvNewRecipes;
    private RecipeRecyclerAdapter recipeRecyclerAdapter;
    public  View view;
    LinearLayoutManager llmRecipesRecommended, llmRecipesPopular, llmRecipesNew;

    public RecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        configureRecipeView(inflater, container);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    private void configureRecipeView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        llmRecipesRecommended =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        configureRecipeRecyclerRecommended();
        configureRecipeRecyclerPopular();
        configureRecipeRecyclerNew();
    }

    private void configureRecipeRecyclerRecommended() {
        llmRecipesRecommended =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvRecommendedRecipes = view.findViewById(R.id.rv_recommended_recipes);
        recipeRecyclerAdapter = new RecipeRecyclerAdapter(DataHolder.getRecipeListRecommended());
        rvRecommendedRecipes.setAdapter(recipeRecyclerAdapter);
        rvRecommendedRecipes.setLayoutManager(llmRecipesRecommended);
        rvRecommendedRecipes.addOnItemTouchListener(
                new RecyclerFeedItemClickListener(getContext(), rvRecommendedRecipes, new RecyclerFeedItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(getContext(), RecipeDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("RECIPE", (Serializable) DataHolder.recipeListRecommended.get(position));
                        i.putExtras(bundle);
                        startActivity(i);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    private void configureRecipeRecyclerPopular() {
        llmRecipesPopular =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPopularRecipes = view.findViewById(R.id.rv_popular_recipes);
        recipeRecyclerAdapter = new RecipeRecyclerAdapter(DataHolder.getRecipeListPopular());
        rvPopularRecipes.setAdapter(recipeRecyclerAdapter);
        rvPopularRecipes.setLayoutManager(llmRecipesPopular);
        rvPopularRecipes.addOnItemTouchListener(
                new RecyclerFeedItemClickListener(getContext(), rvPopularRecipes, new RecyclerFeedItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(getContext(), RecipeDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("RECIPE", (Serializable) DataHolder.recipeListPopular.get(position));
                        i.putExtras(bundle);
                        startActivity(i);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
    private void configureRecipeRecyclerNew() {
        llmRecipesNew =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvNewRecipes = view.findViewById(R.id.rv_new_recipes);
        recipeRecyclerAdapter = new RecipeRecyclerAdapter(DataHolder.getRecipeListRecommended());
        rvNewRecipes.setAdapter(recipeRecyclerAdapter);
        rvNewRecipes.setLayoutManager(llmRecipesNew);
        rvNewRecipes.addOnItemTouchListener(
                new RecyclerFeedItemClickListener(getContext(), rvNewRecipes, new RecyclerFeedItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(getContext(), RecipeDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("RECIPE", (Serializable) DataHolder.recipeListNew.get(position));
                        i.putExtras(bundle);
                        startActivity(i);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }
}