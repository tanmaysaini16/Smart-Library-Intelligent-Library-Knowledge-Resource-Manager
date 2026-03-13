package smartlib.datastructures;

import java.util.*;
import smartlib.models.Book;

public class BookCatalog {

    private HashMap<String, Book> isbnMap = new HashMap<>();
    private ArrayList<Book> bookList = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        isbnMap.put(book.getIsbn(), book);
        bookList.add(book);
    }
 // Remove Book by ISBN
    public boolean removeBook(String isbn) {
        Book book = isbnMap.remove(isbn); // O(1)

        if (book != null) {
            bookList.remove(book); // O(n)
            return true;
        }
        return false;
    }

    // O(1) Search
    public Book searchByISBN(String isbn) {
        return isbnMap.get(isbn);
    }

    // O(n) Linear Search
    public Book searchByTitle(String title) {
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Sort by Publication Year
    public void sortByYear() {
        Collections.sort(bookList, Comparator.comparing(Book::getPublicationYear));
    }

    public ArrayList<Book> getAllBooks() {
        return bookList;
    }
}