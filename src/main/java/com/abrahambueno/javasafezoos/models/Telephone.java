package com.abrahambueno.javasafezoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
//@Table(name = "telephone")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phoneid;

    private String phonetype;

    private String phonenumber;

//    zooid foreign key
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("zoos")
    private Zoo zooidtwo;

    public Telephone() {
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZooidtwo() {
        return zooidtwo;
    }

    public void setZooidtwo(Zoo zooidtwo) {
        this.zooidtwo = zooidtwo;
    }
}
