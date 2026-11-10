package com.banking.model;

import java.time.LocalDate;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private String branch;
    private LocalDate dateOpened;

    public Account(String accountNumber, double balance, String branch) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
        this.dateOpened = LocalDate.now();
    }

    // Abstract methods - must be implemented by subclasses
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    // Protected so only subclasses can change the balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + accountNumber + "] - Balance: BWP " + balance;
    }
}