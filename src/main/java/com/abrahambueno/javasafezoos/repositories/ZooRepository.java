package com.abrahambueno.javasafezoos.repositories;

import com.abrahambueno.javasafezoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Long> {
    Zoo findByZooname(String name);
}
