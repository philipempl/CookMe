package io.frontend.dataholder;

import java.util.List;

import io.frontend.model.Recipe;

public  class DataHolder {

    public static List<Object> feedObjectList;
    public static List<Recipe> recipeListRecommended;
    public static List<Recipe> recipeListPopular;

    public static List<Recipe> getRecipeListNew() {
        return recipeListNew;
    }

    public static void setRecipeListNew(List<Recipe> recipeListNew) {
        DataHolder.recipeListNew = recipeListNew;
    }

    public static List<Recipe> recipeListNew;


    public static List<Recipe> getRecipeListRecommended() {
        return recipeListRecommended;
    }

    public static void setRecipeListRecommended(List<Recipe> recipeListRecommended) {
        DataHolder.recipeListRecommended = recipeListRecommended;
    }

    public static List<Recipe> getRecipeListPopular() {
        return recipeListPopular;
    }

    public static void setRecipeListPopular(List<Recipe> recipeListPopular) {
        DataHolder.recipeListPopular = recipeListPopular;
    }
}
