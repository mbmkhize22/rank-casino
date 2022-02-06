package com.rank.assessment.bonginhlanhla.demo.transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByPlayerId(long playerId);
}
