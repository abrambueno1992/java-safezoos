package com.abrahambueno.javasafezoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zooidtwo")
    @JsonIgnoreProperties("zooidtwo")
    private Set<Telephone> phones;


@ManyToMany(cascade = CascadeType.ALL, mappedBy = "zoos")
@JsonIgnoreProperties("zoos")
private Set<Animal> animals;

    public Zoo() {
    }


    public long getZooid() {

        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public Set<Telephone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Telephone> phones) {
        this.phones = phones;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
