package com.petclinic.core;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private Double accountStatement;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pet> pets = new ArrayList<>();

    protected Owner() {
        // For JPA
    }

    public Owner(Integer id, String firstName, String lastName, Double accountStatement) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountStatement = accountStatement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(Double accountStatement) {
        this.accountStatement = accountStatement;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
