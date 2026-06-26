import java.util.HashMap;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> market = new HashMap<>();

        market.put("TCS", 3503.0);
        market.put("INFY", 1508.0);
        market.put("RELIANCE", 5807.0);

        double balance = 50000;
        HashMap<String, Integer> portfolio = new HashMap<>();

        while (true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");
                    for (String stock : market.keySet()) {
                        System.out.println(stock + " : ₹" + market.get(stock));
                    }
                    break;

                case 2:
                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.next();

                    if (market.containsKey(buyStock)) {
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();

                        double cost = market.get(buyStock) * qty;

                        if (balance >= cost) {
                            balance -= cost;
                            portfolio.put(buyStock,
                                    portfolio.getOrDefault(buyStock, 0) + qty);

                            System.out.println("Stock Purchased Successfully!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                    } else {
                        System.out.println("Stock Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.next();

                    if (portfolio.containsKey(sellStock)) {

                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();

                        int owned = portfolio.get(sellStock);

                        if (qty <= owned) {

                            double amount = market.get(sellStock) * qty;
                            balance += amount;

                            portfolio.put(sellStock, owned - qty);

                            System.out.println("Stock Sold Successfully!");
                        } else {
                            System.out.println("Not Enough Shares!");
                        }
                    } else {
                        System.out.println("Stock Not Owned!");
                    }
                    break;

                case 4:
                    System.out.println("\nPortfolio:");
                    for (String stock : portfolio.keySet()) {
                        System.out.println(stock + " : "
                                + portfolio.get(stock) + " Shares");
                    }

                    System.out.println("Available Balance: ₹" + balance);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}