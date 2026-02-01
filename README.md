# Library Management System

A complete console-based Library Management System built with Java demonstrating OOP principles, file persistence, and clean architecture.

## Features
- ✅ Add, remove, search books
- ✅ Register members and track borrowing
- ✅ Borrow/return books with availability tracking
- ✅ File-based data persistence
- ✅ Input validation and error handling
- ✅ Library statistics
- ✅ Menu-driven interface

## Technologies Used
- Java 8+ (console application)
- Object-Oriented Programming (Encapsulation, Collections)
- File I/O (BufferedReader, PrintWriter)
- ArrayList for dynamic collections
- Exception handling

## File Structure
library-management-system/
│── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── library/
│ │ │ │ ├── Main.java
│ │ │ │ ├── Book.java
│ │ │ │ ├── Member.java
│ │ │ │ ├── Library.java
│ │ │ │ └── FileHandler.java
│ ├── resources/
│── data/
│ ├── books.txt
│ └── members.txt
│── README.md
│── .gitignore
└── pom.xml

## How to Run
1. Create project folder `library-management-system/`
2. Create `src/` and `data/` directories
3. Copy all `.java` files to `src/`
4. Compile: `javac src/*.java`
5. Run: `java -cp src Main`
6. Or use IDE: Open as Java project and run `Main.java`

## Sample Output
=== LIBRARY MANAGEMENT SYSTEM ===
=== MAIN MENU ===

    Add Book

    Remove Book
    ...
    Enter your choice: 1
    Enter ISBN: 12345
    Enter title: Java Programming
    Enter author: John Doe
    Book added successfully!

## Future Improvements
- Book reservation system
- Overdue fine calculation with dates
- CSV export functionality
- Member login system
- Book categories/genres
- Database integration (MySQL/H2)
How to Set Up and Run

    Create the directory structure exactly as shown

    Copy all Java files into src/ folder

    Compile:

    bash
    mkdir library-management-system
    cd library-management-system
    mkdir src data
    # Copy all .java files to src/
    javac src/*.java

    Run:

    bash
    java -cp src Main

This is a production-ready, academic-grade application that demonstrates: