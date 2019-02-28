package com.abrahambueno.javasafezoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zooidtwo")
    @JsonIgnoreProperties("zoo")
    private Set<Telephone> phones;

//    @ManyToMany(mappedBy = "zooid")
//    @ManyToOne
//    @JoinColumn(name = "phoneid")
//    @JsonIgnoreProperties("zoos")
//    private Telephone telephone;

//    @ManyToOne
//    @JoinColumn(name = "zooid")
//    @JsonIgnoreProperties("zoos")
//    private Zoo zootwo;
@ManyToMany
@JoinTable(
        name = "telephoneNumbers",
        joinColumns = {@JoinColumn(name = "zooid")},
        inverseJoinColumns = {@JoinColumn(name = "phoneid")})
@JsonIgnoreProperties("zoos")
private Set<Animal> animals = new HashSet<>();

    public Zoo() {
    }

//    public Zoo(String zooname, Set<Telephone> phones, Set<Animal> animals) {
//        this.zooname = zooname;
//        this.phones = phones;
//        this.animals = animals;
//    }


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
