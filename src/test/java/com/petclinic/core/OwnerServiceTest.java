package com.petclinic.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        var owner = new Owner(null, "Rym", "BA", 100D);
        var luna = new Pet(null, "dog", "luna");
        var miro = new Pet(null, "cat", "miro");
        owner.setPets(of(luna, miro));
        ownerService.save(owner);
    }

    @Test
    void shouldFindOwnerByFirstName() {
        Owner owner = ownerService.findByFirstName("Rym");

        assertThat(owner.getFirstName()).isEqualTo("Rym");
    }

    @Test
    void shouldFindOwnerWithPets() {
        Owner owner = ownerService.findByFirstNameWithPets("Rym");

        assertThat(owner.getPets()).extracting(Pet::getName).contains("luna");
    }
}