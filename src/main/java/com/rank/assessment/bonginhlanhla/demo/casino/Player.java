package com.rank.assessment.bonginhlanhla.demo.casino;

import javax.persistence.*;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long playerId;
    private String playerName;
    private String username;
    private float balance;
    private String password;

    public Player() {
    }

    public Player(String playerName, String username, float balance) {
        this.playerName = playerName;
        this.username = username;
        this.balance = balance;
    }

    public Player(Long playerId, String playerName, String username, float balance) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.username = username;
        this.balance = balance;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}
