
import java.util.Scanner;

class BankAccount {

    int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account1 = new BankAccount(101, "Akash", 5000);
        BankAccount account2 = new BankAccount(102, "Rahul", 10000);

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Select Akash's Account");
            System.out.println("2. Select Rahul's Account");
            System.out.println("3. Exit");
            System.out.print("Choose account: ");

            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Thank you for using our bank!");
                break;
            }

            BankAccount selectedAccount;

            if (choice == 1) {
                selectedAccount = account1;
            } else if (choice == 2) {
                selectedAccount = account2;
            } else {
                System.out.println("Invalid account selection.");
                continue;
            }

            while (true) {

                System.out.println("\n===== ACCOUNT MENU =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Display Details");
                System.out.println("5. Back to Main Menu");
                System.out.print("Choose operation: ");

                int operation = sc.nextInt();

                if (operation == 5) {
                    break;
                }

                switch (operation) {

                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        selectedAccount.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        selectedAccount.withdraw(withdrawAmount);
                        break;

                    case 3:
                        selectedAccount.checkBalance();
                        break;

                    case 4:
                        selectedAccount.displayDetails();
                        break;

                    default:
                        System.out.println("Invalid operation.");
                }
            }
        }

        sc.close();
    }
}
