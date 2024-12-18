package com.petclinic.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @BeforeEach
    void setUp() {
        var visit = new Visit(null, "V01-23", LocalDate.of(2024, 10, 24), "Teeth whitening");
        visit.setOwner(new Owner(null, "joe", "satriani", 1000.0));
        visit.setPet(new Pet(null, "dog", "luna"));
        visitService.save(visit);
    }

    @Test
    void shouldFindByReferenceNumber() {
        Visit visit = visitService.findByReferenceNumber("V01-23");

        assertThat(visit.getIdentifiant()).isEqualTo(1);
        assertThat(visit.getReferenceNumber()).isEqualTo("V01-23");
        assertThat(visit.getPurpose()).isEqualTo("Teeth whitening");
    }

    @Test
    void shouldNotFindByReferenceNumber() {
        assertThat(visitService.findByReferenceNumber("non-existing-reference")).isNull();
    }

    @Test
    void shouldFindVisitWithPet(){
        Visit visit = visitService.findByReferenceNumber("V01-23");

        assertThat(visit.getPet().getName()).isEqualTo("luna");
    }

    @Test
    void shouldFindVisitWithOwner() {
        Visit visit = visitService.findByReferenceNumber("V01-23");

        assertThat(visit.getOwner().getFirstName()).isEqualTo("joe");
    }

}
