package main.java.library;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;
    private String reservedBy; // null if not reserved

    // Constructor
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
        this.reservedBy = null;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public String getReservedBy() { return reservedBy; }

    public void setAvailable(boolean available) { this.available = available; }
    public void reserve(String memberId) { this.reservedBy = memberId; }
    public void cancelReservation() { this.reservedBy = null; }

    @Override
    public String toString() {
        String status = available ? "✅ Available" : 
                       (reservedBy != null ? "🔒 Reserved(" + reservedBy + ")" : "📤 Borrowed");
        return String.format("| %s | %s | %s | %s |", isbn, title, author, status);
    }
}
