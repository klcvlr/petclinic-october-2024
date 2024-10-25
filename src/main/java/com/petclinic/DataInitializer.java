package com.petclinic;

import com.petclinic.core.Owner;
import com.petclinic.core.Pet;
import com.petclinic.core.Visit;
import com.petclinic.core.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

    private final VisitService visitService;

    public DataInitializer(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        Owner owner = new Owner(null, "joe", "satriani", 1000D);
        var pet1 = new Pet(null, "dog", "luna");
        var visit = new Visit(null, "V01-23", LocalDate.of(2013, 12, 21), "Teeth whitening");
        visit.setPet(pet1);
        owner.setPets(List.of(pet1));
        visit.setOwner(owner);
        this.visitService.save(visit);
    }

}
