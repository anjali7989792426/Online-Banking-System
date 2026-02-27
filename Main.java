import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            BankService service = new BankService();

            while (true) {

                System.out.println("\n==== Online Banking System ====");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Balance");
                System.out.println("5. Show Transactions");
                System.out.println("6. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                switch (choice) {

    case 1 -> {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        service.createAccount(accNo, name, balance);
    }

    case 2 -> {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter Amount: ");
        double depositAmount = sc.nextDouble();
        service.deposit(accNo, depositAmount);
    }

    case 3 -> {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter Amount: ");
        double withdrawAmount = sc.nextDouble();
        service.withdraw(accNo, withdrawAmount);
    }

    case 4 -> {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        service.showBalance(accNo);
    }

    case 5 -> {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        service.showTransactions(accNo);
    }

    case 6 -> {
        System.out.println("Thank you for using Banking System!");
        return;
    }

    default -> System.out.println("Invalid choice!");
}
            }
        }
    }
}