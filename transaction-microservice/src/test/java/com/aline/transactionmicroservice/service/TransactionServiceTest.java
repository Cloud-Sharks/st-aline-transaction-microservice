package com.aline.transactionmicroservice.service;

import com.aline.core.model.account.Account;
import com.aline.transactionmicroservice.model.Transaction;
import com.aline.transactionmicroservice.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    TransactionRepository repository;
    TransactionService service;
    Transaction dummyTransaction;

    @BeforeEach
    void setUp() {
        repository = mock(TransactionRepository.class);
        service = new TransactionService(repository);
        dummyTransaction = Transaction.builder()
                .id(1L)
                .amount(10000)
                .date(NOW)
                .account(new Account())
                .build();
        when(repository.save(any())).thenReturn(dummyTransaction);
    }

    @Test
    void test_saveTransaction() {
        Transaction saveTransaction = service.save(dummyTransaction);
        assertEquals(saveTransaction, dummyTransaction);
    }

}
