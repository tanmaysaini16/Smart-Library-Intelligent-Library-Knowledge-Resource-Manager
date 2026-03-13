package smartlib.models;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private int issueCount;
    private boolean available;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = year;
        this.issueCount = 0;
        this.available = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public int getIssueCount() { return issueCount; }
    public boolean isAvailable() { return available; }

    public void issueBook() {
        this.available = false;
        this.issueCount++;
    }

    public void returnBook() {
        this.available = true;
    }

    @Override
    public String toString() {
        return isbn + " | " + title + " | " + author + " | " + publicationYear + 
               " | Issued: " + issueCount;
    }
}
