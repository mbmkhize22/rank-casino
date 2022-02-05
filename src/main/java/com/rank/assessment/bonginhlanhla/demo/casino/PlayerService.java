package com.rank.assessment.bonginhlanhla.demo.casino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List listAllPlayers() {
        return playerRepository.findAll();
    }

    public float getCurrentBalance(long playerId, long transactionId) {
        Boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("Player doesn't exists.");
        }

        Player player = playerRepository.getById(playerId);
        return player.getBalance();
    }
}
