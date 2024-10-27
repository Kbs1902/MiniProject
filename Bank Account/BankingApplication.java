package KBS;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[10]; // Array to hold bank accounts
        int count = 0;

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count < accounts.length) {
                        System.out.print("Enter account holder name: ");
                        String name = scanner.next();
                        System.out.print("Enter account number: ");
                        String accNumber = scanner.next();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();
                        accounts[count++] = new BankAccount();
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Account limit reached.");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccNumber = scanner.next();
                    BankAccount depositAccount = findAccount(accounts, depositAccNumber, count);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccNumber = scanner.next();
                    BankAccount withdrawAccount = findAccount(accounts, withdrawAccNumber, count);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String infoAccNumber = scanner.next();
                    BankAccount infoAccount = findAccount(accounts, infoAccNumber, count);
                    if (infoAccount != null) {
                        infoAccount.displayAccountInfo();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static BankAccount findAccount(BankAccount[] accounts, String accNumber, int count) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accNumber)) {
                return accounts[i];
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}