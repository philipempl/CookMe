package io.frontend.model;

import android.media.Image;

import java.util.Date;
import java.util.List;
import java.util.UUID;

class User {

    UUID uuid;
    String username;
    String prename;
    String surname;
    Image image;
    Date birthDate;
    String password;
    Date firstLogin;
    List<Recipe> listRecipes;
    int profilCalls;
    double impactFactor;
    String aboutMe;

    public User(String username, String password, String prename){
        this.username = username;
        this.password = password;
        this.profilCalls = 0;
        this.birthDate = null;
        this.prename = prename;
        this.impactFactor = 0.0;
        this.firstLogin = new Date();
        this.uuid = UUID.randomUUID();
        this.image = null;
        this.aboutMe = "Hallo zusammen, \n ich heiße " + prename + " und ich nutze CookMe!";

    }
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    public List<Recipe> getListRecipes() {
        return listRecipes;
    }

    public void setListRecipes(List<Recipe> listRecipes) {
        this.listRecipes = listRecipes;
    }

    public int getProfilCalls() {
        return profilCalls;
    }

    public void setProfilCalls(int profilCalls) {
        this.profilCalls = profilCalls;
    }

    public double getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(double impactFactor) {
        this.impactFactor = impactFactor;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
