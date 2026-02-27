import java.util.*;
public class BankService {
    private final Map<Integer, BankAccount> accounts = new HashMap<>();
    public void createAccount(int accNo, String name, double initialBalance) {
        BankAccount account = new BankAccount(accNo, name, initialBalance);
        accounts.put(accNo, account);
        FileUtil.saveAccount(account);
        System.out.println("Account created successfully!");
    }
    public BankAccount getAccount(int accNo) {
        return accounts.get(accNo);
    }
    public void deposit(int accNo, double amount) {
        BankAccount account = accounts.get(accNo);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found!");
        }
    }
    public void withdraw(int accNo, double amount) {
        BankAccount account = accounts.get(accNo);
        if (account != null) {
            try {
                account.withdraw(amount);
                System.out.println("Withdrawal successful!");
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account not found!");
        }
    }
    public void showTransactions(int accNo) {
        BankAccount account = accounts.get(accNo);
        if (account != null) {
            for (String t : account.getTransactionHistory()) {
                System.out.println(t);
            }
        } else {
            System.out.println("Account not found!");
        }
    }
    public void showBalance(int accNo) {
        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
}