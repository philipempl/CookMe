package com.example.philip.vibs.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MultiMediaItem {

    UUID id;
    String username;
    String title;
    int profil;
    Date date;
    int picture;

    public MultiMediaItem(String username, int profil,String title,  Date date, int picutre)
    {
        this.username = username;
        this.title = title;
        this.profil = profil;
        this.date = date;
        this.picture = picutre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
