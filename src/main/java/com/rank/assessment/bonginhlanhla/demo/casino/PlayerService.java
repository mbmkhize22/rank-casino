package com.rank.assessment.bonginhlanhla.demo.casino;

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

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List listAllPlayers() {
        return playerRepository.findAll();
    }

    public ResponseEntity getCurrentBalance(long playerId, long transactionId) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);
        return ResponseEntity.status(HttpStatus.OK).body(player.getBalance());
    }

    public ResponseEntity wager(long playerId, long transactionId, float amount) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);
        LOG.info("BEFORE BALANCE: -> " + player.toString());
        float bal = player.getBalance() - amount;
        player.setBalance(bal);
        LOG.info("AFTER BALANCE: -> " + player.toString());
        return ResponseEntity.status(HttpStatus.OK).body(player.getBalance());
    }

    public ResponseEntity winning(long playerId, long transactionId, float amount) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);
        LOG.info("BEFORE BALANCE: -> " + player.toString());
        float bal = player.getBalance() + amount;
        player.setBalance(bal);
        LOG.info("AFTER BALANCE: -> " + player.toString());
        return ResponseEntity.status(HttpStatus.OK).body(player.getBalance());
    }

    public ResponseEntity transactions(Player player, long transactionId, String transactionType) {
        LOG.info(player.toString());
        return ResponseEntity.status(HttpStatus.OK).body(player.toString());
    }
}
