package com.abrahambueno.javasafezoos.controllers;

import com.abrahambueno.javasafezoos.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class TelephoneController {
    @Autowired
    TelephoneRepository telephonerepos;
}
