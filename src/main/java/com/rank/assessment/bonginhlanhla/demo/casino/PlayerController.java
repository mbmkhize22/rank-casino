package com.rank.assessment.bonginhlanhla.demo.casino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String apiStatus() {
        return "Assessment: Java Engineer [Bonginhlanhla Mkhize] - API Running...";
    }

    @GetMapping(path = "/all-players")
    public List allPlayers() {
        return playerService.listAllPlayers();
    }

    @GetMapping(path = "/current-balance/{playerId}/{transactionId}")
    public ResponseEntity currentBalance(@PathVariable long playerId, @PathVariable long transactionId) {
        return playerService.getCurrentBalance(playerId, transactionId);
    }

    @PostMapping(path = "/wagering/{playerId}/{transactionId}/{amount}")
    public ResponseEntity wagering(@PathVariable long playerId, @PathVariable long transactionId, @PathVariable float amount) {
        return playerService.wager(playerId, transactionId, amount);
    }

    @PostMapping(path = "/winning/{playerId}/{transactionId}/{amount}")
    public ResponseEntity winning(@PathVariable long playerId, @PathVariable long transactionId, @PathVariable float amount) {
        return playerService.winning(playerId, transactionId, amount);
    }

    @PostMapping(path = "/transactions/{transactionId}/{transactionType}")
    public ResponseEntity transactions(@RequestBody Player player, @PathVariable long transactionId, @PathVariable String transactionType) {
        return playerService.transactions(player, transactionId, transactionType);
    }

}
