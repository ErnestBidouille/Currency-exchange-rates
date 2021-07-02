package io.github.ernestbidouille.currencyexchangerates.models;

public class Rate {

    private Double rate;

    public Rate(double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
