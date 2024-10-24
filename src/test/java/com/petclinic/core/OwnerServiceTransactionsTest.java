package com.petclinic.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class OwnerServiceTransactionsTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    void shouldRunInTransaction() {
        assertThat(TransactionSynchronizationManager.isActualTransactionActive()).isTrue();
    }

    @Test
    void shouldTransferFunds() {
        var ownerToCredit = ownerService.save(new Owner(0, "Jimi", "Hendrix", 0D));
        var ownerToDebit = ownerService.save(new Owner(0, "Robert", "Plant", 1000D));
        ownerService.transferFunds(ownerToCredit, ownerToDebit, 200);
        var ownerToCreditRetrieved = ownerService.findByFirstName("Jimi");
        assertThat(ownerToCreditRetrieved.getAccountStatement()).isEqualTo(200);
        var ownerToDebitRetrieved = ownerService.findByFirstName("Robert");
        assertThat(ownerToDebitRetrieved.getAccountStatement()).isEqualTo(800);
    }

    @Test
    void shouldFailTransferBecauseAmountBelowZero() {
        var ownerToCredit = ownerService.save(new Owner(0, "Jimi", "Hendrix", 1000D));
        var ownerToDebit = ownerService.save(new Owner(0, "Robert", "Plant", 10D));

        assertThatThrownBy(() -> ownerService.transferFunds(ownerToCredit, ownerToDebit, 200)).isInstanceOf(RuntimeException.class);

        assertThat(ownerToCredit.getAccountStatement()).isEqualTo(1000D);
        assertThat(ownerToDebit.getAccountStatement()).isEqualTo(10D);
    }
}
