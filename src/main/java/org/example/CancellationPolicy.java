package org.example;


import java.time.LocalDate;

public record CancellationPolicy(LocalDate date, Price amount, String percentage) {


    public CancellationPolicy(LocalDate date, Price amount) {
        this(date, amount, null);
    }

    public CancellationPolicy(LocalDate date, String percentage) {
        this(date, null, percentage);
    }
}
