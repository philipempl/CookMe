package com.example.philip.vibs.model;

import java.util.List;

class Macro {

    double kiloCalories;
    double kiloJoule;
    double protein;
    double fat;
    double carbons;
    double alcohol;
    double water;

    public double getKiloCalories() {
        return kiloCalories;
    }

    public void setKiloCalories(double kiloCalories) {
        this.kiloCalories = kiloCalories;
    }

    public double getKiloJoule() {
        return kiloJoule;
    }

    public void setKiloJoule(double kiloJoule) {
        this.kiloJoule = kiloJoule;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbons() {
        return carbons;
    }

    public void setCarbons(double carbons) {
        this.carbons = carbons;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public static Macro getCalculatedMacro(Macro macroOld, double quanity)
    {
        Macro macroNew = new Macro();
        macroNew.alcohol = macroOld.getAlcohol()*quanity;
        macroNew.carbons = macroOld.getCarbons()*quanity;
        macroNew.fat = macroOld.getFat()*quanity;
        macroNew.kiloJoule = macroOld.getKiloJoule()*quanity;
        macroNew.kiloCalories = macroOld.getKiloCalories()*quanity;
        macroNew.protein = macroOld.getProtein()*quanity;
        macroNew.water = macroOld.getWater()*quanity;

        return macroNew;
    }

    public static Macro getRecipeMacros(List<Ingredient> ingredients)
    {
        Macro macro = new Macro();

        for(Ingredient ingredient : ingredients)
        {
            macro.alcohol += ingredient.macro.getAlcohol();
            macro.carbons += ingredient.macro.getCarbons();
            macro.fat += ingredient.macro.getFat();
            macro.kiloJoule += ingredient.macro.getKiloJoule();
            macro.kiloCalories += ingredient.macro.getProtein();
            macro.protein += ingredient.macro.getKiloCalories();
            macro.water += ingredient.macro.getWater();      }
            return macro;
    }
}
