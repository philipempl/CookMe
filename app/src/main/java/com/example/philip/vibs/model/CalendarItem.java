package com.example.philip.vibs.model;

import java.util.Date;
import java.util.UUID;

public class CalendarItem {

    UUID id;
    String subject;
    Date from;
    Date to;

    public CalendarItem(String subject, Date from, Date to)
    {
        this.subject=subject;
        this.from=from;
        this.to=to;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}

