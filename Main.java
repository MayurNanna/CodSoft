import java.util.Scanner;

// BankAccount class representing user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class representing the ATM machine
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("\nWithdrawal successful. Remaining balance: " + bankAccount.getBalance()+" rupees");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("\nDeposit successful. Current balance: " + bankAccount.getBalance()+" rupees");
    }

    public void checkBalance() {
        System.out.println("\nCurrent balance: " + bankAccount.getBalance()+" rupees");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        int choice;
        do {
            atm.displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("\nEnter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("\nThank you for using the ATM.\nHave a nice day!");
                    break;
                default:
                    System.out.println("\nInvalid option. Please choose again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
