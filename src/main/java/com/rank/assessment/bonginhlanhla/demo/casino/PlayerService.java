package com.rank.assessment.bonginhlanhla.demo.casino;

import com.rank.assessment.bonginhlanhla.demo.transactions.Transaction;
import com.rank.assessment.bonginhlanhla.demo.transactions.TransactionRepository;
import com.rank.assessment.bonginhlanhla.demo.transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PlayerService {
    private static final Logger LOG = Logger.getLogger(PlayerService.class.getName());

    private final PlayerRepository playerRepository;
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TransactionService transactionService, TransactionRepository transactionRepository) {
        this.playerRepository = playerRepository;
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    public List listAllPlayers() {
        return playerRepository.findAll();
    }

    public ResponseEntity getCurrentBalance(long playerId, long transactionId) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);
        return ResponseEntity.status(HttpStatus.OK).body(player.getBalance());
    }

    public ResponseEntity wager(long playerId, long transactionId, float amount) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);

        if(player.getBalance() < amount) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You have less money balance $" + player.getBalance());
        }

        LOG.info("Record transactions");
        Transaction transaction = new Transaction(transactionId, playerId, "wager", amount);
        transactionService.recordTransaction(transaction);

        float bal = player.getBalance() - amount;
        player.setBalance(bal);
        player.setBalance(bal);
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction successful");
    }

    public ResponseEntity winning(long playerId, long transactionId, float amount) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);
        LOG.info("Record transactions");
        Transaction transaction = new Transaction(transactionId, playerId, "win", amount);
        transactionService.recordTransaction(transaction);

        float bal = player.getBalance() + amount;
        player.setBalance(bal);
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction successful");
    }

    public ResponseEntity transactions(Player player, long transactionId, String transactionType) {
        Player _player = playerRepository.findByUsername(player.getUsername());
        if(_player == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player doesn't exists.");
        }

        if(!player.getPassword().equals("swordfish")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You not authorized to view transactions.");
        }

        LOG.info(transactionType);
        return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.findAllByPlayerIdTransactionType(_player.getPlayerId(), transactionType));
    }
}
