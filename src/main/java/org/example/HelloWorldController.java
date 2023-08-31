package org.example;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
class HelloWorldController {
    
    @GetMapping("/quote/{date}")
    public MassageResponse quote(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        if (date.isBefore(LocalDate.now().minusDays(15))) {
            return new MassageResponse("La antelación mínima para reservar es 15 días");
        }
        if (date.isAfter(LocalDate.now().minusDays(15))) {
            return new MassageResponse("No puedes pedir fechas pasadas!");
        }
        var massage1 = new Massage("1", "Masaje sueco", buildStatus(), Duration.ofMinutes(30), new Price(30.0, "EUR"), List.of(new CancellationPolicy(date.minusDays(5), new Price(15.0, "EUR"))));
        var massage2 = new Massage("2", "Masaje deportivo", "ON_REQUEST", Duration.ofMinutes(60), new Price(60.0, "EUR"), List.of(new CancellationPolicy(date.minusDays(5), new Price(30.0, "EUR"))));
        var massage3 = new Massage("3", "Masaje thai", buildStatus(), Duration.ofMinutes(70), new Price(77.0, "EUR"), List.of(new CancellationPolicy(date.minusDays(5), new Price(15.0, "EUR"))));
        var massage4 = new Massage("4", "Masaje de drenaje linfático", buildStatus(), Duration.ofMinutes(80), new Price(85.0, "EUR"), List.of(new CancellationPolicy(date.minusDays(5), new Price(25.0, "EUR"))));
        var massage5 = new Massage("5", "Masaje shiatsu", "DISABLED", Duration.ofMinutes(30), new Price(30.0, "EUR"), List.of(new CancellationPolicy(date.minusDays(5), new Price(35.0, "EUR"))));
        return new MassageResponse(List.of(massage1, massage2, massage3, massage4, massage5));
    }

    private static String buildStatus() {
        return new Random().nextInt(10) == 5 ? "UNAVAILABLE" : "AVAILABLE";
    }
}