package com.banking.model;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private String type;          // DEPOSIT, WITHDRAWAL, INTEREST
    private double amount;
    private LocalDateTime date;
    private Account account;

    public Transaction(String transactionId, String type, double amount, Account account) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.account = account;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return type + " of BWP " + amount + " on " + date + " for account " + account.getAccountNumber();
    }
}