package com.banking.model;

public class InvestmentAccount extends Account implements InterestBearing {

    public static final double MINIMUM_OPENING = 500.00;

    public InvestmentAccount(String accountNumber, double balance, String branch) {
        super(accountNumber, balance, branch);
        if (balance < MINIMUM_OPENING) {
            throw new IllegalArgumentException("Investment Account requires a minimum opening balance of BWP 500.00");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public double calculateMonthlyInterest() {
        return getBalance() * 0.05; // 5%
    }
}