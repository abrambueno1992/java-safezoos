package com.abrahambueno.javasafezoos.repositories;

import com.abrahambueno.javasafezoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByAnimaltype(String name);
}
