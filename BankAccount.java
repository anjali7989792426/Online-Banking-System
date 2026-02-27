import java.util.*;

public class BankAccount {
    private final int accountNumber;
    private final String accountHolderName;
    private double balance;
    private final List<String> transactionHistory;
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }
    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
            return;
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
    }
    @Override
    public String toString() {
        return accountNumber + "," + accountHolderName + "," + balance;
    }
}