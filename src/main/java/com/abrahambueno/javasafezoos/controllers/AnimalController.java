package com.abrahambueno.javasafezoos.controllers;

import com.abrahambueno.javasafezoos.models.Animal;
import com.abrahambueno.javasafezoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {
    @Autowired
    AnimalRepository animalsrepo;

    @GetMapping("/animals/animals")
    public List<Animal> getAllAnimals() {
        return animalsrepo.findAll();
    }
    @GetMapping("/animals/{name}")
    public Animal findAnimalByName(@PathVariable String name) {
        return animalsrepo.findByAnimaltype(name);
    }
}
