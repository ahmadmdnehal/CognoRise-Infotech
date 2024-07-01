package LibraryManagementSystem;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not checked out.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isAvailable ? "Available" : "Checked out");
    }
}

