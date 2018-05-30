package com.example.philip.vibs.model;

import android.media.Image;

import java.util.Date;
import java.util.UUID;

public class InboxItem {

    String uuid;
    String sender;
    String message;
    Date date;
    int image;

    public InboxItem(String sender, int image, String message, Date date)
    {
        this.sender = sender;
        this.image = image;
        this.message = message;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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