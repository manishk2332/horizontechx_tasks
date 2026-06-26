import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> books = new ArrayList<>();

        books.add("Java Programming");
        books.add("computer");
        books.add("Operating System");
        books.add("DBMS");

        while (true) {

            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Add New Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Books:");
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println((i + 1) + ". " + books.get(i));
                    }
                    break;

                case 2:
                    System.out.print("Enter Book Name: ");
                    String issue = sc.nextLine();

                    if (books.remove(issue)) {
                        System.out.println("Book Issued Successfully!");
                    } else {
                        System.out.println("Book Not Available!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Name: ");
                    String book = sc.nextLine();

                    books.add(book);
                    System.out.println("Book Returned Successfully!");
                    break;

                case 4:
                    System.out.print("Enter New Book Name: ");
                    String newBook = sc.nextLine();

                    books.add(newBook);
                    System.out.println("Book Added Successfully!");
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