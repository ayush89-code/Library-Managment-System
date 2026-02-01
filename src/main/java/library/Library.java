package main.java.library;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private Scanner scanner;

    public Library(Scanner scanner) {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.scanner = scanner;
    }

    // CORE OPERATIONS
    public void addBook() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine().trim();
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Author: ");
        String author = scanner.nextLine().trim();

        Book book = new Book(isbn, title, author);
        books.add(book);
        saveData();
        System.out.println("✅ Book added successfully!");
    }

    public void removeBook() {
        System.out.print("Enter ISBN to remove: ");
        String isbn = scanner.nextLine().trim();
        books.removeIf(b -> b.getIsbn().equals(isbn));
        saveData();
        System.out.println("✅ Book removed!");
    }

    public void registerMember() {
        System.out.print("Member ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        Member member = new Member(id, name);
        members.add(member);
        saveData();
        System.out.println("✅ Member registered!");
    }

    public void borrowBook() {
        displayAvailableBooks();
        System.out.print("Member ID: ");
        String memberId = scanner.nextLine().trim();
        Member member = findMember(memberId);
        if (member == null) {
            System.out.println("❌ Member not found!");
            return;
        }

        System.out.print("Book ISBN: ");
        String isbn = scanner.nextLine().trim();
        Book book = findBook(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(isbn);
            saveData();
            System.out.println("✅ Book borrowed!");
        } else {
            System.out.println("❌ Book not available!");
        }
    }

    public void returnBook() {
        System.out.print("Member ID: ");
        String memberId = scanner.nextLine().trim();
        Member member = findMember(memberId);
        if (member == null) return;

        displayMemberBooks(member);
        System.out.print("Book ISBN: ");
        String isbn = scanner.nextLine().trim();

        if (member.returnBook(isbn)) {
            Book book = findBook(isbn);
            if (book != null) book.setAvailable(true);
            saveData();
            System.out.println("✅ Book returned!");
        } else {
            System.out.println("❌ Book not found with member!");
        }
    }

    // Helper methods
    private Book findBook(String isbn) {
        for (Book b : books) if (b.getIsbn().equals(isbn)) return b;
        return null;
    }

    private Member findMember(String id) {
        for (Member m : members) if (m.getMemberId().equals(id)) return m;
        return null;
    }

    private void displayAvailableBooks() {
        System.out.println("\n📚 AVAILABLE BOOKS:");
        boolean found = false;
        for (Book b : books) {
            if (b.isAvailable()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No available books!");
        System.out.println();
    }

    private void displayMemberBooks(Member member) {
        System.out.println("\n📖 " + member.getName() + "'s books:");
        for (Member.BorrowRecord r : member.getBorrowedBooks()) {
            Book b = findBook(r.isbn);
            if (b != null) System.out.println(b);
        }
        System.out.println();
    }

    // Save/Load data
    public void saveData() {
        FileHandler.saveBooks(books);
        FileHandler.saveMembers(members);
    }

    public void loadData() {
        books = FileHandler.loadBooks();
        members = FileHandler.loadMembers();
        System.out.println("📂 Data loaded!");
    }

    // Statistics
    public void showStats() {
        long totalBooks = books.size();
        long available = books.stream().filter(Book::isAvailable).count();
        long membersCount = members.size();
        double totalFines = 0;
        for (Member m : members) totalFines += m.getTotalFines();

        System.out.println("\n📊 STATISTICS:");
        System.out.printf("📚 Total Books: %d%n", totalBooks);
        System.out.printf("✅ Available: %d%n", available);
        System.out.printf("📤 Borrowed: %d%n", totalBooks - available);
        System.out.printf("👥 Members: %d%n", membersCount);
        System.out.printf("💰 Total Fines: $%.2f%n", totalFines);
    }

    // Search
    public void searchBooks() {
        System.out.print("Search (title/author): ");
        String keyword = scanner.nextLine().toLowerCase().trim();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword) || 
                b.getAuthor().toLowerCase().contains(keyword)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("❌ No books found!");
    }
}
