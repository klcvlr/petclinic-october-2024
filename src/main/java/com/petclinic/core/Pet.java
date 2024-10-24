package com.petclinic.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String name;

    protected Pet() {
        // For JPA
    }

    public Pet(Integer id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
