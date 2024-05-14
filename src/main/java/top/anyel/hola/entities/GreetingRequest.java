package top.anyel.hola.entities;

import java.time.LocalDate;

public record GreetingRequest (String name, String lastName, String address, LocalDate birthdate) {
}
