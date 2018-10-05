package com.example.philip.vibs;

import com.example.philip.vibs.model.Recipe;

import java.util.List;

public  class DataHolder {

    public static List<Recipe> recipeList;
    public static List<Object> feedObjectList;
    public static boolean swipeRight, swipeLeft;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    //test
    public List<Object> getFeedObjectList() {
        return feedObjectList;
    }

    public void setFeedObjectList(List<Object> feedObjectList) {
        this.feedObjectList = feedObjectList;
    }

    public static boolean isSwipeRight() {
        return swipeRight;
    }

    public static void setSwipeRight(boolean swipeRight) {
        DataHolder.swipeRight = swipeRight;
    }

    public static boolean isSwipeLeft() {
        return swipeLeft;
    }

    public static void setSwipeLeft(boolean swipeLeft) {
        DataHolder.swipeLeft = swipeLeft;
    }

}
