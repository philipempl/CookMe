package io.frontend.model;

import java.io.Serializable;
import java.util.UUID;

public class FoodStuff implements Serializable {

    UUID id;
    String name;
    String description;
    Macro macros;
    String allergy;
    double price;
    double amount;
    String unit;

    public FoodStuff(String name, String description, Macro macro, double price, String unit, double amount) {
        //this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.macros = macro;
        this.price = price;
        if(unit == null)
        {
            this.unit ="";
        }
        else {
            this.unit = unit;
        }
        this.amount = amount;
        //this.allergy = Allergy.getAllergy(name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Macro getMacros() {
        return macros;
    }

    public void setMacros(Macro macros) {
        this.macros = macros;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.unit = unit;
    }
}
