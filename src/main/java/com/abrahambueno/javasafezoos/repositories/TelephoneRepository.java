package com.abrahambueno.javasafezoos.repositories;

import com.abrahambueno.javasafezoos.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
