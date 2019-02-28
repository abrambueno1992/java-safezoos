package com.abrahambueno.javasafezoos.service;

import com.abrahambueno.javasafezoos.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
}
