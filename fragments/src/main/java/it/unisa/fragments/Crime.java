package it.unisa.fragments;

import static java.time.LocalDate.of;

import java.time.LocalDate;
import java.util.UUID;


public class Crime {

    private UUID id;
    private String title;
    private LocalDate todayDate;
    private Boolean solved;
    public Crime() {
        id = UUID.randomUUID();
        String year = null;
        String month = null;
        String day = null;
        todayDate = of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
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

    public LocalDate getDate() {
        return todayDate;
    }

    public void setDate(LocalDate date) {
        todayDate = date;
    }

    public Boolean isSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }
}
