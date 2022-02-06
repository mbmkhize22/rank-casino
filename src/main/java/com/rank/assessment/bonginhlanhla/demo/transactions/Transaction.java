package com.rank.assessment.bonginhlanhla.demo.transactions;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "trans_sequence",
            sequenceName = "trans_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trans_sequence"
    )
    private Long transactionIdPk;
    private Long transactionId;
    private Long playerId;
    private String transactionType;
    private float amount;

    public Transaction() {
    }

    public Transaction(Long transactionId, Long playerId, String transactionType, float amount) {
        this.transactionId = transactionId;
        this.playerId = playerId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Transaction(Long transactionIdPk, Long transactionId, Long playerId, String transactionType, float amount) {
        this.transactionIdPk = transactionIdPk;
        this.transactionId = transactionId;
        this.playerId = playerId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Long getTransactionIdPk() {
        return transactionIdPk;
    }

    public void setTransactionIdPk(Long transactionIdPk) {
        this.transactionIdPk = transactionIdPk;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
