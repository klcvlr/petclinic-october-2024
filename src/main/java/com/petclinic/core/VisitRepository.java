package com.petclinic.core;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class VisitRepository {

    public Visit findByReferenceNumber(String referenceNumber){
        return new Visit(1, referenceNumber, LocalDate.now(), "visite de routine");
    }

}