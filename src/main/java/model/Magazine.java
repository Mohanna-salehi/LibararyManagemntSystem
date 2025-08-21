package model;

import jakarta.persistence.Entity;

@Entity
public class Magazine extends Item{

    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
