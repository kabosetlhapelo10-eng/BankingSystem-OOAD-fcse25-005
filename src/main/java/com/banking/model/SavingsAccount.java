package com.banking.model;

public class SavingsAccount extends Account implements InterestBearing {

    public SavingsAccount(String accountNumber, double balance, String branch) {
        super(accountNumber, balance, branch);
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
        throw new UnsupportedOperationException("Withdrawals are not allowed from a Savings Account");
    }

    @Override
    public double calculateMonthlyInterest() {
        return getBalance() * 0.0005; // 0.05%
    }
}