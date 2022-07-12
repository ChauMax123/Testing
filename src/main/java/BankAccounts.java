public class BankAccounts {
    private double balance;

    public BankAccounts() {
        balance = 0;  // account opening Balance
    }

    public BankAccounts(double balance) {
        balance = this.balance;
    }

    public static void main(String args[]) {
        BankAccounts bankAccount1 = new BankAccounts();
        BankAccounts bankAccount2 = new BankAccounts();

        System.out.println(bankAccount1.deposit(4000));
        System.out.println(bankAccount1.withdraw(3000));
        System.out.println(bankAccount1.deposit(3000));

        // checking current balance in the account.
        System.out.println(bankAccount1.printBalance());

        // Checking condition deposit more than max limit 5000
        System.out.println(bankAccount1.deposit(6000));

        //Checking transferFrom method functionality
        System.out.println(bankAccount2.deposit(3000));
        System.out.println(bankAccount1.transferFrom(bankAccount2, 3000));
        System.out.println("Account summary from Bank account 1: " + bankAccount1.printBalance());
        System.out.println("Account summary from Bank account 2: " + bankAccount2.printBalance());
        System.out.println(bankAccount1.transferFrom(bankAccount2, 2000));
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String deposit(double amount) {
        if (amount > 5000) {
            return "Transaction canceled. Max deposit - 5000 | Your deposit: " + amount;
        } else {
            setBalance(this.balance + amount);
            return "Amount " + amount + " deposited successfully!";
        }
    }

    public String withdraw(double amount) {
        if (balance < amount)
            return "There is not enough funds.";
        balance -= amount;
        return "Current Balance left in the account is :" + this.balance;
    }

    public String printBalance() {
        return "This is the current Balance :" + balance;
    }

    public String transferFrom(BankAccounts bankAccount, double transferAmount) {
        if (this.balance > transferAmount) {
            bankAccount.balance += transferAmount;
            this.balance -= transferAmount;
            return "Amount transferred successfully!";
        } else {
            return "Transfer canceled. You are trying to transfer " + transferAmount + " units, but only " + this.balance + " are available.";
        }
    }
}
