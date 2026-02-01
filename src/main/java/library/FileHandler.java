package main.java.library;
import java.io.*;
// import java.time.LocalDate;
import java.util.*;

public class FileHandler {
    private static final String BOOKS_FILE = "data/books.txt";
    private static final String MEMBERS_FILE = "data/members.txt";

    public static void saveBooks(List<Book> books) {
        ensureDataDir();
        try (PrintWriter out = new PrintWriter(BOOKS_FILE)) {
            for (Book b : books) {
                out.println(b.getIsbn() + "|" + b.getTitle() + "|" + 
                           b.getAuthor() + "|" + b.isAvailable() + "|" + 
                           (b.getReservedBy() != null ? b.getReservedBy() : ""));
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ Cannot save books");
        }
    }

    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        File file = new File(BOOKS_FILE);
        if (!file.exists()) return books;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    book.setAvailable(Boolean.parseBoolean(parts[3]));
                    if (parts.length > 4 && !parts[4].trim().isEmpty()) {
                        book.reserve(parts[4].trim());
                    }
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Cannot load books");
        }
        return books;
    }

    public static void saveMembers(List<Member> members) {
        ensureDataDir();
        try (PrintWriter out = new PrintWriter(MEMBERS_FILE)) {
            for (Member m : members) {
                StringBuilder booksData = new StringBuilder();
                for (Member.BorrowRecord r : m.getBorrowedBooks()) {
                    booksData.append(r.isbn).append(",");
                }
                out.println(m.getMemberId() + "|" + m.getName() + "|" + 
                           booksData.toString() + "|" + m.getTotalFines());
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ Cannot save members");
        }
    }

    public static List<Member> loadMembers() {
        List<Member> members = new ArrayList<>();
        File file = new File(MEMBERS_FILE);
        if (!file.exists()) return members;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    Member member = new Member(parts[0], parts[1]);
                    if (parts.length > 2 && !parts[2].trim().isEmpty()) {
                        String[] isbns = parts[2].split(",");
                        for (String isbn : isbns) {
                            if (!isbn.trim().isEmpty()) {
                                member.borrowBook(isbn.trim());
                            }
                        }
                    }
                    if (parts.length > 3) {
                        try {
                            member.totalFines = Double.parseDouble(parts[3]);
                        } catch (NumberFormatException ignored) {}
                    }
                    members.add(member);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Cannot load members");
        }
        return members;
    }

    private static void ensureDataDir() {
        new File("data").mkdirs();
    }
}
