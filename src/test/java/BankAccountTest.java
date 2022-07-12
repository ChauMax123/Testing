import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    BankAccounts bankAccount;

    @BeforeEach
    void getBankInstanceTest(){
        bankAccount = new BankAccounts();
    }
    @Test
    void setBalance(){
        bankAccount.setBalance(4000);
        assertEquals(4000, bankAccount.getBalance(), 0.0);
    }
    @Test
    public void depositTest(){
        bankAccount.deposit(4000);
        assertEquals(4000, bankAccount.getBalance(),0.0);
        assertEquals("Transaction canceled. Max deposit - 5000 | Your deposit: 7000.0", bankAccount.deposit(7000));
    }
    @Test
    void withdrawTest(){
        bankAccount.deposit(4000);
        double balanceBeforeWithdraw = bankAccount.getBalance();
        bankAccount.withdraw(3000);
        assertEquals( bankAccount.getBalance(), balanceBeforeWithdraw-3000, 0.0);
        assertEquals("There is not enough funds.", bankAccount.withdraw(2000));
    }

    @Test
    void printBalanceTest(){
        bankAccount.setBalance(100);
        assertEquals("This is the current Balance :100.0",bankAccount.printBalance());
    }
    @Test
    void transferFromTest(){
        String transferStatus = bankAccount.transferFrom(new BankAccounts(), 3000);
        assertEquals("Transfer canceled. You are trying to transfer 3000.0 units, but only 0.0 are available.", transferStatus );
        bankAccount.deposit(4000);
        assertEquals("Amount transferred successfully!", bankAccount.transferFrom(new BankAccounts(), 3000));
    }
}

