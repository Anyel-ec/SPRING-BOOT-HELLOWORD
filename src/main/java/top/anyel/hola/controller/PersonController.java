package top.anyel.hola.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.anyel.hola.entity.Person;

@RestController
@RequestMapping("/person/v1")
public class PersonController {

    @PostMapping(value = "/save")
    public Person save(@RequestBody Person person) {
        return person;
    }

}