package main.java.library;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<BorrowRecord> borrowedBooks;
    double totalFines;

    // Inner class for borrow records
    public static class BorrowRecord {
        String isbn;
        LocalDate borrowDate;
        LocalDate dueDate;

        public BorrowRecord(String isbn, LocalDate borrowDate) {
            this.isbn = isbn;
            this.borrowDate = borrowDate;
            this.dueDate = borrowDate.plusDays(14); // 14 days due
        }
    }

    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.totalFines = 0.0;
    }

    // Core methods
    public void borrowBook(String isbn) {
        borrowedBooks.add(new BorrowRecord(isbn, LocalDate.now()));
    }

    public boolean returnBook(String isbn) {
        BorrowRecord record = findRecord(isbn);
        if (record != null) {
            long overdueDays = Math.max(0, ChronoUnit.DAYS.between(record.dueDate, LocalDate.now()));
            if (overdueDays > 0) {
                double fine = overdueDays * 1.0; // $1 per day
                totalFines += fine;
            }
            borrowedBooks.remove(record);
            return true;
        }
        return false;
    }

    private BorrowRecord findRecord(String isbn) {
        for (BorrowRecord r : borrowedBooks) {
            if (r.isbn.equals(isbn)) return r;
        }
        return null;
    }

    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getBorrowedCount() { return borrowedBooks.size(); }
    public double getTotalFines() { return totalFines; }
    public List<BorrowRecord> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }

    @Override
    public String toString() {
        return String.format("👤 %s (ID: %s) | 📚 %d books | 💰 $%.2f", 
                           name, memberId, borrowedBooks.size(), totalFines);
    }
}
