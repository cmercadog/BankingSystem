package org.jalasoft;

import java.util.HashMap;
import java.util.Set;

/**
 * Bank
 */
public class Bank {

    /**
     * Key: represents the account number.
     * Value: represents the balance.
     */

    private HashMap<Integer, Integer> accounts;
    private int nextAccount;
    private double interestRate;

    public Bank() {
        accounts = new HashMap<>();
        nextAccount = 0;
        interestRate = 0.01;
    }
    
    /**
     * Create a new account and assign it an account number and sets the balance to 0
     * 
     * @return the account number
     */
    public int newAccount() {
        accounts.put(nextAccount, 0);
        int currentAccount= nextAccount++;
        return currentAccount;
    }

    /**
     * Return the current balance of a given account
     * @param accountNumber the account where the balance will be checked
     * @return the balance of the given account
     */
    public int getBalance(int accountNumber) {
        return accounts.get(accountNumber);
    }

    /**
     * This increases the amount of balance in a given account
     * 
     * @param accountNumber the account where the amount will be deposited
     * @param amount the amount of money that will increase the balance
     * 
     * @return if the transaction was executed successfully
     */
    public boolean deposit(int accountNumber, int amount) {
        int balance = accounts.get(accountNumber);
        accounts.put(accountNumber, balance + amount);
        return true;
    }

    /**
     * Verify if the amount requested can be assigned to a given account based on its current balance
     * 
     * @param accountNumber the account that we will verify on
     * @param loanAmount the requested amount to be verified
     * @return whether the amount was approved or not
     */
    public boolean authorizeLoan(int accountNumber, int loanAmount) {
        int balance = accounts.get(accountNumber);
        return (balance >= loanAmount / 2);
    }

    /**
     * This method deposit a certain amount of money to all accounts based on a interest rate
     * @return whether the interest payment process was successful or not
     */
    public boolean  payInterest() {
        Set<Integer> accountNumbers = accounts.keySet();
        for (int accountNumber : accountNumbers) {
            int balance = accounts.get(accountNumber);
            int newbalance = (int) (balance * (1 + interestRate));
            accounts.put(accountNumber, newbalance);
        }
       return true;
    }

    @Override
    public String toString() {
        StringBuilder accountsAsText = new StringBuilder();
        Set<Integer> accountNumbers = accounts.keySet();

        accountsAsText.append("The bank has " + accountNumbers.size() + " accounts.");
        for (int accountNumber : accountNumbers)
            accountsAsText
                  .append( System.lineSeparator())
                  .append("\tAccount ").append(accountNumber)
                  .append(": balance=").append(accounts.get(accountNumber));
         
        return accountsAsText.toString();
    }
}