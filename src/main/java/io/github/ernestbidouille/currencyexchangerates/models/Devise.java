package io.github.ernestbidouille.currencyexchangerates.models;

import javax.persistence.*;

@Entity
public class Devise {
    @Id
    @Column(
            nullable = false,
            unique = true
    )
    private String name;

    public Devise() {
    }

    public Devise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
