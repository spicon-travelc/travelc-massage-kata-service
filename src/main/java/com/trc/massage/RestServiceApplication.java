package com.trc.massage;

import com.trc.massage.binding.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.time.Duration.ofMinutes;


@SpringBootApplication
public class RestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}

@RestController
class MassageController {

    @GetMapping("/massages/quote/{date}")
    public MassageResponse quoteMassage(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        if (date.isBefore(LocalDate.now().plusDays(15))) {
            return new MassageResponse("La antelación mínima para reservar es de 15 días");
        }
        var massages = buildMassages(date);
        return new MassageResponse(massages);
    }

    private static List<Massage> buildMassages(LocalDate date) {
        var massage1 = new Massage("1"
                , "Masaje sueco"
                , "AVAILABLE"
                , new Price(25.0, "EUR")
                , ofMinutes(30)
                , List.of(new CancellationPolicy(date.minusDays(5), new Price(15.0, "EUR"))
                , new CancellationPolicy(date.minusDays(6), new Price(25.0, "EUR"))));
        var massage2 = new Massage("2"
                , "Masaje de Aromaterapia con luces de colores"
                , "ON_REQUEST"
                , new Price(300.0, "EUR")
                , ofMinutes(85)
                , Collections.emptyList());
        var massage3 = new Massage("3"
                , "Masaje Deportivo 60 minutos"
                , "AVAILABLE"
                , new Price(60.0, "EUR")
                , ofMinutes(60)
                , List.of(new CancellationPolicy(date.minusDays(3), new Price(30.0, "EUR")),
                    new CancellationPolicy(date.minusDays(3), new Price(40.0, "EUR"))
                , new CancellationPolicy(date.plusDays(1), new Price(50.0, "EUR"))));
        var massage4 = new Massage("4"
                , "Masaje Deportivo 45 minutos"
                , "AVAILABLE"
                , new Price(45.0, "EUR")
                , ofMinutes(45)
                , List.of(new CancellationPolicy(date.minusDays(10), new Price(0.0, "EUR"))
                , new CancellationPolicy(date, new Price(45.0, "EUR"))));
        var massage5 = new Massage("5"
                , "Masaje de piedras calientes"
                ,  "AVAILABLE"
                , new Price(150.0, "EUR")
                , ofMinutes(70)
                , List.of(new CancellationPolicy(date.minusDays(365), new Price(150.0, "EUR"))));
        var massage6 = new Massage("6"
                , "Masaje Tailandés"
                ,  "UNAVAILABLE"
                , new Price(100.0, "EUR")
                , ofMinutes(70)
                , List.of(new CancellationPolicy(date.minusDays(365), new Price(100.0, "EUR"))));
        var massage7 = new Massage("7"
                , "Masaje Shiatsu"
                , "DISABLED"
                , new Price(150.0, "EUR")
                , ofMinutes(90)
                , List.of(new CancellationPolicy(date.minusDays(365), new Price(0.0, "EUR"))));
        var massage8 = new Massage("8"
                , "Masaje de Aromaterapia"
                , "AVAILABLE"
                , new Price(50.0, "EUR")
                , ofMinutes(85)
                , List.of(new CancellationPolicy(date.minusDays(15), new Price(15.0, "EUR"))
                , new CancellationPolicy(date.minusDays(5), new Price(25.0, "EUR"))
                , new CancellationPolicy(date.minusDays(2), new Price(40.0, "EUR"))));
        return List.of(massage1, massage2, massage3, massage4, massage5, massage6, massage7, massage8);
    }
}


