package com.rank.assessment.bonginhlanhla.demo.casino;

import org.springframework.beans.factory.annotation.Autowired;
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
    public float currentBalance(@PathVariable long playerId, @PathVariable long transactionId) {
        return playerService.getCurrentBalance(playerId, transactionId);
    }

    @PostMapping(path = "/wagering/{playerId}/{transactionId}")
    public float wagering(@PathVariable long playerId, @PathVariable long transactionId) {
        return playerService.getCurrentBalance(playerId, transactionId);
    }

    @PostMapping(path = "/winning/{playerId}/{transactionId}")
    public float winning(@PathVariable long playerId, @PathVariable long transactionId) {
        return playerService.getCurrentBalance(playerId, transactionId);
    }

}
