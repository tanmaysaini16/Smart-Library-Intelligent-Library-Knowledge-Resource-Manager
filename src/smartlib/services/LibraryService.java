package smartlib.services;

import smartlib.datastructures.*;
import smartlib.models.Book;

public class LibraryService {

    private BookCatalog catalog = new BookCatalog();
    private UndoStack undoStack = new UndoStack();

    public void addBook(Book book) {
        catalog.addBook(book);
    }

    // ✅ THIS METHOD MUST BE INSIDE THE CLASS
    public String searchBook(String isbn) {
        Book book = catalog.searchByISBN(isbn);
        if (book != null) {
            return book.toString();
        }
        return "Book not found.";
    }

    public void issueBook(String isbn) {
        Book book = catalog.searchByISBN(isbn);
        if (book != null && book.isAvailable()) {
            book.issueBook();
            undoStack.push("Issued " + isbn);
            System.out.println("Book Issued!");
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(String isbn) {
        Book book = catalog.searchByISBN(isbn);
        if (book != null) {
            book.returnBook();
            undoStack.push("Returned " + isbn);
            System.out.println("Book Returned!");
        }
    }
    public void removeBook(String isbn) {
        Book book = catalog.searchByISBN(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Cannot remove. Book is currently issued.");
            return;
        }

        boolean removed = catalog.removeBook(isbn);

        if (removed) {
            undoStack.push("Removed " + isbn);
            System.out.println("Book Removed Successfully!");
        }
    }

    public void undoAction() {
        System.out.println(undoStack.undo());
    }

    public void showAllBooks() {
        for (Book b : catalog.getAllBooks()) {
            System.out.println(b);
        }
    }
}