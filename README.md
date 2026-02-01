# 🚀 Week 3: Library Management System

[![Java 11](https://img.shields.io/badge/Java-11-orange.svg)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**Production-ready Java console application** demonstrating OOP principles, Maven, file persistence, and clean architecture.

---

## ✨ **Core Features** ✅

| **Feature** | **Status** | **Description** |
|-------------|------------|-----------------|
| 📚 **Book Management** | ✅ | Add, remove, search by title/author |
| 👥 **Member Management** | ✅ | Register, track borrowing history |
| 📤 **Borrow/Return** | ✅ | 14-day loans with availability |
| 💰 **Overdue Fines** | ✅ | $1/day automatic calculation |
| 🔒 **Reservations** | ✅ | Book reservation system |
| 📊 **Statistics** | ✅ | Real-time library dashboard |
| 💾 **Data Persistence** | ✅ | Auto-save/load `books.txt`, `members.txt` |

---

## 📂 **Exact Project Structure**

Lirary-Management-System/
├── pom.xml # Maven configuration
├── src/
│ └── main/
│ └── java/
│ └── library/ # Java package
│ ├── Main.java
│ ├── Book.java
│ ├── Member.java
│ ├── Library.java
│ └── FileHandler.java
├── data/ # Auto-generated
│ ├── books.txt
│ └── members.txt
├── README.md
└── .gitignore


---

## 🚀 **Quick Start** (3 Commands)

### **Maven Terminal**
```bash
mvn clean compile     # Compile
mvn exec:java         # Run
mvn clean package     # Build JAR

IDE Setup

text
IntelliJ: File → Open → pom.xml → Maven Reload
Eclipse: Import → Existing Maven Projects
VS Code: Java Extension Pack → F5

🎮 Live Demo Output

🎉 Welcome to Library Management System!
==================================================
📚 LIBRARY MANAGEMENT SYSTEM
1. ➕ Add Book      2. 🗑️  Remove Book
3. 👤 Add Member   4. 📤 Borrow Book
5. 📥 Return Book  6. 🔍 Search Books
7. 📊 Statistics   8. 💾 Export CSV
0. ❌ Exit
➤ Choose (0-8): 1

ISBN: 978-0134685991
Title: Clean Code
Author: Robert C. Martin
✅ Book added successfully!

📊 Statistics Dashboard

📊 STATISTICS:
📚 Total Books: 5
✅ Available: 3
📤 Borrowed: 2
👥 Members: 2
💰 Total Fines: $3.50
============================

🛠️ Technical Implementation
Java Concept	Usage
Classes/Objects	Book, Member, Library
Encapsulation	Private fields + getters/setters
Collections	ArrayList<Book>, ArrayList<Member>
File I/O	BufferedReader, PrintWriter
Date/Time	LocalDate for due dates
Streams	Statistics calculations
📋 Menu System
Option	Function	Validation
1	Add Book	Non-empty fields
2	Remove Book	ISBN exists
3	Register Member	Unique ID
4	Borrow Book	Book available + member exists
5	Return Book	Calculates overdue fines
6	Search	Title/author keywords
7	Statistics	Real-time counts
8	CSV Export	data/library_export.csv
🔧 File Formats
data/books.txt

978-0134685991|Clean Code|Robert C. Martin|true|
978-0321356680|Design Patterns|Erich Gamma|false|M001

data/members.txt

M001|John Doe|978-0321356680,|2.50
M002|Jane Smith||0.00

🎓 Learning Objectives Covered ✅


✅ Java Syntax & OOP Principles
✅ Classes, Objects, Methods
✅ Encapsulation (private + public)
✅ ArrayList Collections
✅ File I/O Operations
✅ Exception Handling
✅ Input Validation
✅ Control Structures (switch, loops)
✅ Console I/O (Scanner)

🧪 Testing Checklist

✅ [ ] mvn clean compile → No errors
✅ [ ] mvn exec:java → Runs perfectly
✅ [ ] Add book → Saves to books.txt
✅ [ ] Borrow/return → Updates status
✅ [ ] Overdue fines → $1/day correct
✅ [ ] Search → Finds books
✅ [ ] Statistics → Accurate counts
✅ [ ] Data persists → Restart works

🔍 Troubleshooting
Problem	Solution
package library does not exist	Add package library; to ALL 5 Java files
mvn command not found	Use IDE (IntelliJ/Eclipse)
data/ folder missing	Auto-created on first run
Java version error	java --version → 11+ required
🌟 Future Enhancements


[ ] H2/MySQL Database
[ ] Spring Boot REST API
[ ] Web UI Dashboard
[ ] Email Notifications
[ ] Multi-language Support
[ ] Advanced Reporting
[ ] Member Login System