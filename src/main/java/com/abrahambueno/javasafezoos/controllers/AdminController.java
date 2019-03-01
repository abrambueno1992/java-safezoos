package com.abrahambueno.javasafezoos.controllers;

import com.abrahambueno.javasafezoos.models.Animal;
import com.abrahambueno.javasafezoos.models.Telephone;
import com.abrahambueno.javasafezoos.models.Zoo;
import com.abrahambueno.javasafezoos.repositories.AnimalRepository;
import com.abrahambueno.javasafezoos.repositories.TelephoneRepository;
import com.abrahambueno.javasafezoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    ZooRepository zoorepos;

    @Autowired
    TelephoneRepository telephonerepos;

    @Autowired
    AnimalRepository animalrepos;

    @PostMapping("/zoos")
    public Zoo addZoo(@RequestBody Zoo zoo) throws URISyntaxException {
        return zoorepos.save(zoo);
    }
//    @PostMapping("/zoos/animals")

    // works
    @PutMapping("/zoos/{id}")
    public Zoo changeZoo(@RequestBody Zoo zoo, @PathVariable long id) throws URISyntaxException {
        Optional<Zoo> updateZoo = zoorepos.findById(id);
        if (updateZoo.isPresent()) {
            if (zoo.getAnimals() == null) {
                zoo.setAnimals(updateZoo.get().getAnimals());
            }
            if (zoo.getPhones() == null) {
                zoo.setPhones(updateZoo.get().getPhones());
            }
            zoo.setZooid(id);
            zoorepos.save(zoo);
            return zoo;
        } else {
            return null;
        }
    }
    // might need to return String
    @DeleteMapping("/zoos/{id}")
    public Zoo deleteZooById(@PathVariable long id) throws URISyntaxException {
        var deleteZoo = zoorepos.findById(id);
        if (deleteZoo.isPresent()) {
            zoorepos.deleteById(id);
//            zoorepos.deleteZooFromAnimals(id);
//            zoorepos.deleteFromPhonenumbers(id);
            // return something
            return deleteZoo.get();
        } else {
            return null;
        }
    }
//    @DeleteMapping("/zoos/{zooid}/animals/{animalid}")

    @PostMapping("/phones")
    public Telephone addTelephone(@RequestBody Telephone phone) throws URISyntaxException {
        return telephonerepos.save(phone);
    }

    // works
    @PutMapping("/phones/{id}")
    public Telephone changePhone(@RequestBody Telephone phone, @PathVariable long id) throws URISyntaxException {
        Optional<Telephone> updatePhone = telephonerepos.findById(id);
        if (updatePhone.isPresent()) {
            if (phone.getZooidtwo() == null) {
                phone.setZooidtwo(updatePhone.get().getZooidtwo());
            }
            if (phone.getPhonenumber() == null) {
                phone.setPhonenumber(updatePhone.get().getPhonenumber());
            }

            phone.setPhoneid(id);
            telephonerepos.save(phone);
            return phone;
        } else {
            return null;
        }
    }
    // might need to return String
    @DeleteMapping("/phones/{id}")
    public Telephone deleteTelephone(@PathVariable long id) throws URISyntaxException {
        var deleteTelephone = telephonerepos.findById(id);
        if (deleteTelephone.isPresent()) {
            telephonerepos.deleteById(id);
            return  deleteTelephone.get();
        } else {
            return null;
        }
    }
    @PostMapping("/animals")
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalrepos.save(animal);
    }
    // works now
    @PutMapping("/animals/{id}")
    public Animal changeAnimal(@RequestBody Animal animal, @PathVariable long id) throws URISyntaxException {
        Optional<Animal> updateAnimal = animalrepos.findById(id);
        if (updateAnimal.isPresent()) {
            if (animal.getZoos() == null) {
                animal.setZoos(updateAnimal.get().getZoos());
            }
            animal.setAnimalid(id);
            animalrepos.save(animal);
            return animal;
        } else {
            return null;
        }
    }
    // might need to return Strin
    @DeleteMapping("/animals/{id}")
    public Animal deleteAnimal(@PathVariable long id) throws URISyntaxException {
        var deleteAnimal = animalrepos.findById(id);
        if (deleteAnimal.isPresent()) {
            animalrepos.deleteById(id);
            return deleteAnimal.get();
        } else {
            return null;
        }
    }


}
