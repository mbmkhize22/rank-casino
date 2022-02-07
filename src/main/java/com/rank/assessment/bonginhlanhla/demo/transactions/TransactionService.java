package com.rank.assessment.bonginhlanhla.demo.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService {
    private static final Logger LOG = Logger.getLogger(TransactionService.class.getName());
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Cacheable("transactions_b")
    public List listAllTransactions(long id) {
        return transactionRepository.findAll();
    }

    public void recordTransaction(Transaction transaction) {
        LOG.info(transaction.toString());
        transactionRepository.save(transaction);
    }
}
