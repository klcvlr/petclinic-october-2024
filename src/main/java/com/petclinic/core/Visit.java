package com.petclinic.core;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class Visit {
    @Id
    @GeneratedValue
    private Integer identifiant;
    @Column(unique = true)
    private String referenceNumber;
    private LocalDate date;
    private String purpose;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Pet pet;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Owner owner;

    protected Visit() {
        // For JPA
    }

    public Visit(Integer identifiant, String referenceNumber, LocalDate date, String purpose) {
        this.identifiant = identifiant;
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.purpose = purpose;
    }

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
