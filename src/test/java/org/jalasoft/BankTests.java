package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * BankTests
 */
public class BankTests {

    @Test
    public void createNewAccount() {
        //Arrange -- Initialize variables
        Bank bank = new Bank();
        
        //Act
        int accountZero = bank.newAccount();
        int accountOne = bank.newAccount();
        int accountTwo = bank.newAccount();
        int accountThree = bank.newAccount();

        //Assert
        assertEquals(0, accountZero);
        assertEquals(1, accountOne);
        assertEquals(2, accountTwo);
        assertEquals(3, accountThree);
    }
    @Test
    public void deositAmountToAccount() {
        //Arrange
        Bank bank = new Bank();
        int accountZero = bank.newAccount();

        //Act
        bank.deposit(accountZero, 100);
        //Assert
        assertEquals(100, bank.getBalance(accountZero));
        
    }

}