package com.trc.massage.binding;


import java.time.LocalDate;

public record CancellationPolicy(LocalDate date, Price price) {
}
