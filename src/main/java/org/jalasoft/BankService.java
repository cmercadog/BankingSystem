package org.jalasoft;

/**
 * BankService
 */
public class BankService {
    private Bank bank;

    public BankService() {
        this.bank = new Bank();
    }

    
    /**
     * Ask a given to account to bank and then grabs the balance
     * 
     * @param accountNumber account number to check balance
     * @return balance of a given account
     */
    public int getBalance(int accountNumber) {
        BankAccount bankAccount = bank.getBankAccount(accountNumber);
        return bankAccount.getBalance();
    }

    /**
     * Create a new account and assign it an account number and sets the balance to 0
     * 
     * @return The account number
     */
    public int newAccount() {
        return bank.newAccount();
    }

    /**
     * This increases the amount of balance in a given account
     * 
     * @param accountNumber the account where the amount will be deposited
     * @param amount        the amount of money that will increase the balance
     * 
     * @return if the transaction was executed successfully
     */
    public boolean deposit(int accountNumber, int amount) {
        BankAccount bankAccount = bank.getBankAccount(accountNumber);
        return bankAccount.deposit(amount);
                
        
    }


     /**
     * Verify if the amount requested can be assigned to a given account based on
     * its current balance
     * 
     * @param accountNumber the account that we will verify on
     * @param loanAmount    the requested amount to be verified
     * @return whether the amount was approved or not
     */
    public boolean authorizeLoan(int accountNumber, int loanAmount) {
        BankAccount bankAccount = bank.getBankAccount(accountNumber);
        return bankAccount.hasEnoughCollateral(loanAmount);

        //int balance = accounts.get(accountNumber);
        //return balance >= loanAmount / 2;
        
    }

    /**
     * This method deposit a certain amount of money to all accounts based on a
     * interest rate
     * 
     * @return whether the interest payment process was successful or not
     */
    public boolean payInterest() { 
       
        return  bank.payInterest();
    }

    /**
     * 
     * @return the bank information with using the bank own format
     */
    public String getBankInformation() {
        return bank.toString();
    }
}