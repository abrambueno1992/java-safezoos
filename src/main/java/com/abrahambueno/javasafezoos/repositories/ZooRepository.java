package com.abrahambueno.javasafezoos.repositories;

import com.abrahambueno.javasafezoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, Long> {
    List<Zoo> findByZoonameEquals(String name);
}
