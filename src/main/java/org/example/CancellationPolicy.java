package org.example;

import java.time.LocalDate;

public class CancellationPolicy {


    private LocalDate date;
    private Price amount;

    public CancellationPolicy(LocalDate date, Price amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Price getAmount() {
        return amount;
    }

    public void setAmount(Price amount) {
        this.amount = amount;
    }

}
