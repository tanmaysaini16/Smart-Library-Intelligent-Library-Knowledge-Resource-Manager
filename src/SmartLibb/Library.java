package SmartLibb;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Library {

    Scanner sc = new Scanner(System.in);

    Book[] books = new Book[100];
    User[] users = new User[100];

    int bookCount = 0;
    int userCount = 0;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    void addBook() {

        System.out.print("Enter Book ID: ");
        String id = sc.next();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books[bookCount++] = new Book(id, title, author);

        System.out.println("Book Added Successfully");
    }

    void displayBooks() {

        if (bookCount == 0) {
            System.out.println("No books available");
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            books[i].display();
        }
    }

    void deleteBook() {

        System.out.print("Enter Book ID to delete: ");
        String id = sc.next();

        for (int i = 0; i < bookCount; i++) {

            if (books[i].id.equals(id)) {

                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }

                bookCount--;
                System.out.println("Book Deleted");
                return;
            }
        }

        System.out.println("Book not found");
    }

    void addUser() {

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        users[userCount++] = new User(id, name);

        System.out.println("User Added");
    }

    void issueBook() {

        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book ID: ");
        String bid = sc.next();
        sc.nextLine();

        User user = null;
        Book book = null;

        for (int i = 0; i < userCount; i++) {
            if (users[i].userId == uid) {
                user = users[i];
                break;
            }
        }

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        if (user.borrowedCount >= 3) {
            System.out.println("User cannot borrow more than 3 books");
            return;
        }

        for (int i = 0; i < bookCount; i++) {

            if (books[i].id.equals(bid)) {
                book = books[i];
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (book.issued) {
            System.out.println("Book Unavailable (Already Issued)");
            return;
        }

        System.out.print("Enter Issue Date (dd-MM-yyyy): ");
        LocalDate issueDate = LocalDate.parse(sc.nextLine(), formatter);

        System.out.print("Enter Due Date (dd-MM-yyyy): ");
        LocalDate dueDate = LocalDate.parse(sc.nextLine(), formatter);

        int index = user.borrowedCount;

        user.borrowedBooks[index] = bid;   // ADD THIS LINE
        user.issueDates[index] = issueDate;
        user.dueDates[index] = dueDate;

        user.borrowedCount++;

        book.issued = true;

        System.out.println("Book Issued Successfully");
    }

    void returnBook() {

        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book ID: ");
        String bid = sc.next();

        sc.nextLine();   // clears leftover enter

        System.out.print("Enter Return Date (dd-MM-yyyy): ");
        String dateInput = sc.nextLine();

        LocalDate returnDate = LocalDate.parse(dateInput, formatter);
        for (int i = 0; i < userCount; i++) {

            if (users[i].userId == uid) {

                User user = users[i];

                for (int j = 0; j < user.borrowedCount; j++) {

                    if (user.borrowedBooks[j] != null && user.borrowedBooks[j].equals(bid)) {

                        long lateDays = ChronoUnit.DAYS.between(user.dueDates[j], returnDate);

                        if (lateDays > 0) {

                            double penalty = 2.5 * lateDays;

                            user.totalPenalty += penalty;

                            System.out.println("Late by " + lateDays + " days");
                            System.out.println("Penalty: " + penalty);

                        } else {
                            System.out.println("Returned on time");
                        }

                        for (int k = j; k < user.borrowedCount - 1; k++) {

                            user.borrowedBooks[k] = user.borrowedBooks[k + 1];
                            user.issueDates[k] = user.issueDates[k + 1];
                            user.dueDates[k] = user.dueDates[k + 1];
                        }

                        user.borrowedCount--;

                        for (int k = 0; k < bookCount; k++) {

                            if (books[k].id.equals(bid)) {
                                books[k].issued = false;
                            }
                        }

                        System.out.println("Book Returned");
                        return;
                    }
                }
            }
        }

        System.out.println("Record not found");
    }

    void userHistory() {

        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();

        for (int i = 0; i < userCount; i++) {

            if (users[i].userId == uid) {

                users[i].displayHistory();
                return;
            }
        }

        System.out.println("User not found");
    }
}