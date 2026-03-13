package SmartLibb;
import java.time.LocalDate;

class User {

    int userId;
    String name;

    int borrowedCount = 0;

    String[] borrowedBooks = new String[3];
    LocalDate[] issueDates = new LocalDate[3];
    LocalDate[] dueDates = new LocalDate[3];

    double totalPenalty = 0;

    User(int id, String name) {
        this.userId = id;
        this.name = name;
    }

    void displayHistory() {

        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);

        if (borrowedCount == 0) {
            System.out.println("Books Borrowed: 0");
        } else {

            System.out.println("Books Borrowed: " + borrowedCount);

            for (int i = 0; i < borrowedCount; i++) {

                System.out.println("Book ID: " + borrowedBooks[i]);
                System.out.println("Issue Date: " + issueDates[i]);
                System.out.println("Due Date: " + dueDates[i]);
                System.out.println();
            }
        }

        System.out.println("Total Penalty (if any): " + totalPenalty);
    }
}