package com.petclinic.core;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit findByReferenceNumber(String referenceNumber){
        return visitRepository.findByReferenceNumber(referenceNumber);
    }

    public void save(Visit visit){
        visitRepository.save(visit);
    }

    public Optional<Visit> findById(Integer id) {
        return visitRepository.findById(id);
    }
}
