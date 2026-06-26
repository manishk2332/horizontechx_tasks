import java.util.Scanner;

public class BankingApplication {

    static double balance = 5000;

    public static void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful!");
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public static void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SIMPLE BANKING APPLICATION =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Withdraw Amount: ");
                    withdraw(sc.nextDouble());
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}