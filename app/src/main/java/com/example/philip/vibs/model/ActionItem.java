package com.example.philip.vibs.model;

import java.util.Date;
import java.util.UUID;

public class ActionItem {

    UUID id;
    String username;
    String requestMessage;
    Date date;
    Date time;
    int image;
    String location;
    public ActionItem (String username, int image, String requestMessage, String location, Date time, Date date)
    {
        this.username = username;
        this.image = image;
        this.requestMessage = requestMessage;
        this.location = location;
        this.time = time;
        this.date = date;
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

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
