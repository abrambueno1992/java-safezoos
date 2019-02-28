package com.abrahambueno.javasafezoos.repositories;

import com.abrahambueno.javasafezoos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

