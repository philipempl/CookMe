package com.example.philip.vibs.model;

import java.util.UUID;

public class BirthdayItem {

    UUID id;
    String personName;
    int age;
    int image;

    public BirthdayItem(String personName,int image,  int age)
    {
        this.personName = personName;
        this.image = image;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
