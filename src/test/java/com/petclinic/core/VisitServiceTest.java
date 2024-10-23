package com.petclinic.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    void shouldFindByReferenceNumber() {
        Visit visit = visitService.findByReferenceNumber("myRef");

        assertThat(visit.getReferenceNumber()).isEqualTo("myRef");
        assertThat(visit.getIdentifiant()).isEqualTo(1);
        assertThat(visit.getPurpose()).isEqualTo("visite de routine");
    }
}