package LibraryManagementSystem;

import java.util.ArrayList;

public class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " by " + book.getAuthor() + " added to the catalog.");
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("No book found with the title: " + title);
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkOut();
                return;
            }
        }
        System.out.println("No book found with the title: " + title);
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("No book found with the title: " + title);
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

