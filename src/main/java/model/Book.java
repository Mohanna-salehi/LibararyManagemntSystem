package model;


import com.sun.istack.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Book extends Item{

    private String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
