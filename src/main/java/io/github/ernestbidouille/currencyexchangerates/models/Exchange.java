package io.github.ernestbidouille.currencyexchangerates.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "date", "sourceDevise", "destinationDevise" }))
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;
    @ManyToOne
    private Devise sourceDevise;
    @ManyToOne
    private Devise destinationDevise;
    private Double rate;
    private Date date;

    public Exchange() {
    }

    public Exchange(Devise sourceDevise, Devise destinationDevise, Double rate, Date date) {
        this.sourceDevise = sourceDevise;
        this.destinationDevise = destinationDevise;
        this.rate = rate;
        this.date = date;
    }

    public Devise getSourceDevise() {
        return sourceDevise;
    }

    public void setSourceDevise(Devise sourceDevise) {
        this.sourceDevise = sourceDevise;
    }

    public Devise getDestinationDevise() {
        return destinationDevise;
    }

    public void setDestinationDevise(Devise destinationDevise) {
        this.destinationDevise = destinationDevise;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
