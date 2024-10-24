package com.petclinic.core;

import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner findByFirstName(String firstName){
        return this.ownerRepository.findByFirstName(firstName);
    }

    public void save(Owner owner){
        this.ownerRepository.save(owner);
    }

    public Owner findByFirstNameWithPets(String firstName) {
        return this.ownerRepository.findByFirstNameWithPets(firstName);
    }
}
