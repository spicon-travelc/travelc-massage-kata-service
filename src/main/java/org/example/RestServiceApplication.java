package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
class HelloWorldController {

    @GetMapping("/massage/quote/{date}")
    public MassageResponse quoteMassage(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        if (date.isBefore(LocalDate.now().minusDays(15))) {
            return new MassageResponse("La antelación mínima para reservar es de 15 días");
        }
        var massages = buildMassages(date);
        return new MassageResponse(massages);
    }

    @GetMapping("/massage/therapist")
    public TherapistResponse getTherapist() {
        var therapist1 = new Therapist("1", "María López", new Price(30.0, "EUR"), true);
        var therapist2 = new Therapist("2", "Carlos Rodríguez", new Price(55.0, "EUR"), false);
        var therapist3 = new Therapist("3", "Luciana Alcuaz", new Price(70.0, "EUR"), true);
        return new TherapistResponse(List.of(therapist1, therapist2, therapist3));
    }

    private static List<Massage> buildMassages(LocalDate date) {
        var massage1 = new Massage("1"
                , "Masaje sueco"
                , buildStatus()
                , ofMinutes(30)
                , List.of(new CancellationPolicy(date.minusDays(5), new Price(15.0, "EUR"))
                , new CancellationPolicy(date.minusDays(6), new Price(30.0, "EUR"))));
        var massage2 = new Massage("2"
                , "Masaje de Aromaterapia"
                , "ON_REQUEST"
                , ofMinutes(85)
                , List.of(new CancellationPolicy(date.minusDays(15), "25")
                , new CancellationPolicy(date.minusDays(5), "50")
                , new CancellationPolicy(date.minusDays(2), "100")));
        var massage3 = new Massage("3"
                , "Masaje Deportivo 60 minutos"
                , buildStatus()
                , ofMinutes(60)
                , List.of(new CancellationPolicy(date.minusDays(3), "50")
                , new CancellationPolicy(date.plusDays(1), "100")));
        var massage4 = new Massage("4"
                , "Masaje Deportivo 45 minutos"
                , buildStatus()
                , ofMinutes(45)
                , List.of(new CancellationPolicy(date.minusDays(10), "0")
                , new CancellationPolicy(date, "100")));
        var massage5 = new Massage("5"
                , "Masaje Tailandés"
                , buildStatus()
                , ofMinutes(70)
                , List.of(new CancellationPolicy(date.minusDays(365), new Price(100.0, "EUR"))));
        var massage6 = new Massage("6"
                , "Masaje Shiatsu"
                , "DISABLED"
                , ofMinutes(90)
                , List.of(new CancellationPolicy(date.minusDays(365), new Price(0.0, "EUR"))));
        return List.of(massage1, massage2, massage3, massage4, massage5, massage6);
    }

    private static String buildStatus() {
        return new Random().nextInt(10) == 5 ? "UNAVAILABLE" : "AVAILABLE";
    }
}


