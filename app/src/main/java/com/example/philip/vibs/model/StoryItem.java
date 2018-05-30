package com.example.philip.vibs.model;

import java.util.Date;
import java.util.UUID;

public class StoryItem {

    UUID id;
    String username;
    String title;
    String message;
    Date date;
    int image;

    public StoryItem(String username, String title, String message, Date date, int image)
    {
        this.username = username;
        this.title = title;
        this.message = message;
        this.date = date;
        this.image = image;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
