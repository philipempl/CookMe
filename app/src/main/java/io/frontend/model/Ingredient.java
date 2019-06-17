package io.frontend.model;

import android.widget.TextView;

import java.io.Serializable;

public class Ingredient implements Serializable {

    FoodStuff foodStuff;
    double price;
    Macro macro;
    double quantity;

    public Ingredient(FoodStuff foodStuff, double quantity)
    {
        this.quantity = quantity;
        this.foodStuff = foodStuff;
        //this.macro = Macro.getCalculatedMacro(foodStuff.getMacros(), quantity);
        //this.price = calculatePrice(quantity);
    }

    public void changeQuantity(double factor)
    {
        this.quantity = this.quantity * factor;
        this.macro = Macro.getCalculatedMacro(foodStuff.getMacros(), quantity);
        this.price = calculatePrice(quantity);
    }
    public double calculatePrice(double quantity)
    {
        return (quantity/foodStuff.getAmount())*foodStuff.getPrice();
    }
    public FoodStuff getFoodStuff() {
        return foodStuff;
    }

    public void setFoodStuff(FoodStuff foodStuff) {
        this.foodStuff = foodStuff;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Macro getMacro() {
        return macro;
    }

    public void setMacro(Macro macro) {
        this.macro = macro;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
