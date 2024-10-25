package com.petclinic.core;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner findByFirstName(String firstName){
        return this.ownerRepository.findByFirstName(firstName);
    }

    public Owner save(Owner owner){
        return this.ownerRepository.save(owner);
    }

    public Owner findByFirstNameWithPets(String firstName) {
        return this.ownerRepository.findByFirstNameWithPets(firstName);
    }

    @Transactional
    public void transferFunds(Owner ownerToCredit, Owner ownerToDebit, double amount) {
        debitAmount(ownerToDebit, amount);
        creditAmount(ownerToCredit, amount);
    }

    private void debitAmount(Owner ownerToDebit, double amount) {
        double ownerToDebitNewAmount = ownerToDebit.getAccountStatement() - amount;
        if (ownerToDebitNewAmount < 0)
            throw new RuntimeException("account value cannot be below zero");
        ownerToDebit.setAccountStatement(ownerToDebitNewAmount);
        this.ownerRepository.save(ownerToDebit);
    }

    private void creditAmount(Owner ownerToCredit, double amount) {
        double ownerToCreditNewAmount = ownerToCredit.getAccountStatement() + amount;
        ownerToCredit.setAccountStatement(ownerToCreditNewAmount);
        this.ownerRepository.save(ownerToCredit);
    }

    public Optional<Owner> findById(Integer id) {
        return ownerRepository.findById(id);
    }
}
