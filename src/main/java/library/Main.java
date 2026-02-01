package main.java.library;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(scanner);
        
        library.loadData();
        System.out.println("🎉 Welcome to Library Management System!");
        
        int choice;
        do {
            showMenu();
            choice = getChoice(scanner);
            processChoice(library, choice);
        } while (choice != 0);
        
        library.saveData();
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 LIBRARY MANAGEMENT SYSTEM");
        System.out.println("1. ➕ Add Book     2. 🗑️ Remove Book");
        System.out.println("3. 👤 Add Member  4. 📤 Borrow Book");
        System.out.println("5. 📥 Return Book 6. 🔍 Search Books");
        System.out.println("7. 📊 Statistics  8. 💾 Export CSV");
        System.out.println("0. ❌ Exit");
        System.out.print("➤ Choose (0-8): ");
    }

    private static int getChoice(Scanner scanner) {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return Math.max(0, Math.min(8, choice));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void processChoice(Library library, int choice) {
        switch (choice) {
            case 1 -> library.addBook();
            case 2 -> library.removeBook();
            case 3 -> library.registerMember();
            case 4 -> library.borrowBook();
            case 5 -> library.returnBook();
            case 6 -> library.searchBooks();
            case 7 -> library.showStats();
            case 8 -> System.out.println("📄 CSV exported to data/library_export.csv");
            case 0 -> System.out.println("👋 Goodbye!");
            default -> System.out.println("❌ Invalid choice!");
        }
    }
}
