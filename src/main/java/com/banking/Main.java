package com.banking;

import com.banking.model.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== BANKING SYSTEM - CORE MODEL TEST =====\n");

        // 1. Create a Customer
        Customer customer = new Customer(
                "C001",
                "Kabo",
                "Setlhapelo",
                "Gaborone",
                "password123"
        );

        System.out.println("Customer created: " + customer);
        System.out.println("Login successful? " + customer.login("password123"));
        System.out.println();

        // 2. Create different types of accounts
        SavingsAccount savings = new SavingsAccount("SAV001", 1000.00, "Main Branch");
        InvestmentAccount investment = new InvestmentAccount("INV001", 2000.00, "Main Branch");
        ChequeAccount cheque = new ChequeAccount("CHQ001", 5000.00, "Main Branch",
                "Botswana University", "Private Bag 0022, Gaborone");

        // 3. Link accounts to the customer
        customer.addAccount(savings);
        customer.addAccount(investment);
        customer.addAccount(cheque);

        System.out.println("Accounts opened for " + customer.getFirstName() + ":");
        for (Account acc : customer.getAccounts()) {
            System.out.println("  → " + acc);
        }
        System.out.println();

        // 4. Test Deposit
        System.out.println("----- Testing Deposits -----");
        savings.deposit(500.00);
        investment.deposit(1000.00);
        cheque.deposit(2000.00);

        System.out.println("After deposits:");
        System.out.println("  Savings Balance   : BWP " + savings.getBalance());
        System.out.println("  Investment Balance: BWP " + investment.getBalance());
        System.out.println("  Cheque Balance    : BWP " + cheque.getBalance());
        System.out.println();

        // 5. Test Withdrawals
        System.out.println("----- Testing Withdrawals -----");
        try {
            savings.withdraw(100); // This should fail
        } catch (Exception e) {
            System.out.println("Savings withdrawal blocked: " + e.getMessage());
        }

        investment.withdraw(300);
        cheque.withdraw(1000);

        System.out.println("After withdrawals:");
        System.out.println("  Investment Balance: BWP " + investment.getBalance());
        System.out.println("  Cheque Balance    : BWP " + cheque.getBalance());
        System.out.println();

        // 6. Test Interest Calculation
        System.out.println("----- Testing Monthly Interest -----");
        double savingsInterest = savings.calculateMonthlyInterest();
        double investmentInterest = investment.calculateMonthlyInterest();

        System.out.println("Savings Interest (0.05%): BWP " + savingsInterest);
        System.out.println("Investment Interest (5%): BWP " + investmentInterest);

        // Credit the interest
        savings.deposit(savingsInterest);
        investment.deposit(investmentInterest);

        System.out.println("\nBalances after interest credited:");
        System.out.println("  Savings   : BWP " + savings.getBalance());
        System.out.println("  Investment: BWP " + investment.getBalance());
        System.out.println();

        System.out.println("===== CORE MODEL TEST COMPLETED SUCCESSFULLY =====");
    }
}