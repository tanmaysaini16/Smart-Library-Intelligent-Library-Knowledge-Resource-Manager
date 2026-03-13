package SmartLibb;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        int choice;

        do {

            System.out.println("\n=== SMART LIBRARY SYSTEM === ");
            System.out.println("1 Add Book");
            System.out.println("2 Display Books");
            System.out.println("3 Delete Book");
            System.out.println("4 Add User");
            System.out.println("5 Issue Book");
            System.out.println("6 Return Book");
            System.out.println("7 User History");
            System.out.println("8 Total Books");
            System.out.println("9 Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    lib.addBook();
                    break;

                case 2:
                    lib.displayBooks();
                    break;

                case 3:
                    lib.deleteBook();
                    break;

                case 4:
                    lib.addUser();
                    break;

                case 5:
                    lib.issueBook();
                    break;

                case 6:
                    lib.returnBook();
                    break;

                case 7:
                    lib.userHistory();
                    break;

                case 8:
                    System.out.println("Total Books: " + lib.bookCount);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 9);
        sc.close();
    }
}