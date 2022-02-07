package com.rank.assessment.bonginhlanhla.demo.transactions;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.playerId = ?1 AND t.transactionType = ?2")
    List<Transaction> findAllByPlayerIdTransactionType(long playerId, String transactionType);
}
