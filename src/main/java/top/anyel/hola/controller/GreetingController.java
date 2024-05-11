package top.anyel.hola.controller;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.anyel.hola.entities.Greeting;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hola, %s %s! Ud. vive en %s y nacio el %s. ";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Angel") String name,
                             @RequestParam(value = "lastName", defaultValue = "Patiño") String lastName,
                             @RequestParam(value = "address", defaultValue = "Santo Domingo") String address,
                             @RequestParam(value = "birthdate", defaultValue = "2002-05-12") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate) {
        String formattedDate = birthdate.toString(); // convertir la fecha a string
        int age = calculateAge(birthdate); // calcular la edad
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name, lastName, address, formattedDate), (age));
    }

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    private int calculateAge(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now(); // obtener la fecha actual
        return Period.between(birthdate, currentDate).getYears(); // calcular la diferencia en años y obtenemos asi la edad
    }
}

