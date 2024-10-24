package com.petclinic.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitServiceUnitTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitService visitService;

    @Test
    void shouldFindVisitByReferenceNumber() {
        var mockedVisit = new Visit(1, "mocked referenceNumber", LocalDate.now(), "unit visit");
        when(visitRepository.findByReferenceNumber(any())).thenReturn(mockedVisit);

        Visit visit = visitService.findByReferenceNumber("number");

        assertThat(visit.getIdentifiant()).isEqualTo(1);
        assertThat(visit.getReferenceNumber()).isEqualTo("mocked referenceNumber");
        assertThat(visit.getPurpose()).isEqualTo("unit visit");
    }
}
