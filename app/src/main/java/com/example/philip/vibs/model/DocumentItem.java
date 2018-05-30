package com.example.philip.vibs.model;

import java.util.Date;
import java.util.UUID;

public class DocumentItem {

    UUID id;
    String username;
    String title;
    String document_name;
    Date date;
    int image;

    public DocumentItem(String username, String title, String document_name, Date date, int image)
    {
        this.username = username;
        this.title = title;
        this.document_name = document_name;
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

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
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
