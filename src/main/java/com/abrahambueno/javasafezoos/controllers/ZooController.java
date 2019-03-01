package com.abrahambueno.javasafezoos.controllers;

import com.abrahambueno.javasafezoos.models.Zoo;
import com.abrahambueno.javasafezoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zoos/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {
    @Autowired
    ZooRepository zoorepos;

    @GetMapping("/zoos")
    public List<Zoo> getZoos() {
        return zoorepos.findAll();
    }
    @GetMapping("/{name}")
    public List<Zoo> getZooByName(@PathVariable String  name) {
        return zoorepos.findByZoonameEquals(name);
    }

}
