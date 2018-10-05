package com.example.philip.vibs.model;

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Recipe implements Serializable {

    UUID uuid;
    String title;
    String description;
    List<Integer> listImages;
    int likes;
    List<Ingredient> listIngredients;
    int portion;
    int portionTmp;
    int duration;
    int clicks;
    Macro macro;
    double price;
    String level;
    List<CookingStep> steps;
    List<String> allergies;
    Date date;
    User user;

    public Recipe(String title, String description, List<Integer> images, int portion, List<Ingredient> ingredients, int duration, String level, List<CookingStep> steps)
    {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.listImages = images;
        this.portion = portion;
        this.description = description;
        this.listIngredients = ingredients;
        this.duration = duration;
//        this.macro = Macro.getRecipeMacros(ingredients);
  //      this.price = calculatePrice();
    //    this.allergies = getAllergies();
        this.clicks = 0;
        this.likes = 0;
        this.level = level;
        this.steps = steps;
        this.portionTmp = portion;
        this.date = new Date();

        System.out.println("GRÖ????E"+ listImages.size());
    }

    private double calculatePrice() {
        double price = 0;
        for(Ingredient ingredient : listIngredients)
        {
            price += ingredient.price;
        }
        return price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getListImages() {
        return listImages;
    }

    public void setListImages(List<Integer> listImages) {
        this.listImages = listImages;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Ingredient> getListIngredients() {
        return listIngredients;
    }

    public void setListIngredients(List<Ingredient> listIngredients) {
        this.listIngredients = listIngredients;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPortionTmp() {
        return portionTmp;
    }

    public void setPortionTmp(int portionTmp) {
        this.portionTmp = portionTmp;
    }

    public Macro getMacro() {
        return macro;
    }

    public void setMacro(Macro macro) {
        this.macro = macro;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CookingStep> getSteps() {
        return steps;
    }

    public void setSteps(List<CookingStep> steps) {
        this.steps = steps;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getAllergies() {

        List<String> allergies = new ArrayList<>();
        for(Ingredient ingredient : listIngredients)
        {
            allergies.add(ingredient.getFoodStuff().getAllergy());
        }
        return allergies;
    }

    public void changeIngredientQuantity(double factor)
    {
        for(Ingredient ingredient : listIngredients)
        {
            ingredient.setQuantity(ingredient.getQuantity()*factor);
        }
    }
    public void setUpUserPortion(int portion)
    {
        portionTmp = portion;
        double factor = portion/this.portion;
        this.price = 0;
        for(Ingredient ingredient : listIngredients)
        {
            this.price = ingredient.calculatePrice(factor);

        }
    }
}