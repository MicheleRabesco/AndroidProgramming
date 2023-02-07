package it.unisa.fragments;

import java.util.Date;
import java.util.UUID;


public class Crime {

    private UUID id;
    private String title;
    private Date date;
    private Boolean solved;
    public Crime() {
        id = UUID.randomUUID();
        date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean isSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }
}
