package SmartLibb;
class Book {

    String id;
    String title;
    String author;
    boolean issued;

    Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    void display() {
        System.out.println("Book ID: " + id + " | Title: " + title + " | Author: " + author + " | Issued: " + issued);
    }
}