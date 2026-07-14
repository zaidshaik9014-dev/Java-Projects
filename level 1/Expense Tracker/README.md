# 💰 Expense Tracker (Java)

A feature-rich **console-based Expense Tracker** built using **Core Java** and **Object-Oriented Programming (OOP)**.

This project was developed to move beyond Java syntax and apply programming concepts to a real-world application. It allows users to manage daily expenses efficiently while demonstrating clean project structure, file handling, and data persistence.

> 🚀 This is **Project #1** in my journey of building **100 Java Projects** to strengthen my problem-solving skills and software development knowledge.

---

# 📌 Features

- ➕ Add Expense
- 📋 View All Expenses
- 🔍 Search Expense by ID
- ✏️ Update Existing Expense
- 🗑️ Delete Expense
- 💰 Calculate Total Spending
- 📊 Category-wise Expense Report
- 🆔 Auto-generated Expense IDs
- 📅 Automatic Date using `LocalDate`
- 💾 Save Expenses to File
- 📂 Automatically Load Saved Expenses
- 🔄 Persistent Data Across Program Runs
- 🖥️ Menu-driven Console Interface

---

# 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- File Handling
- LocalDate API
- Scanner Class
- BufferedReader
- BufferedWriter
- Exception Handling (File I/O)

---

# 📂 Project Structure

```
Expense Tracker
│
├── Expense.java
├── ExpenseManager.java
├── FileManager.java
├── Main.java
├── expenses.txt
├── .gitignore
└── README.md
```

---

# 🧠 Java Concepts Practiced

- Classes & Objects
- Constructors
- Encapsulation
- Getters & Setters
- Method Overriding (`toString()`)
- ArrayList
- Enhanced For Loop
- CRUD Operations
- Returning Objects
- Null Handling
- File Handling
- BufferedReader & BufferedWriter
- LocalDate
- Menu-driven Programming
- Clean Code Organization

---

# 🚀 How It Works

### Add Expense

The user enters:

- Title
- Category
- Amount

The application automatically:

- Generates a unique Expense ID
- Records the current date using `LocalDate`
- Saves the expense into memory
- Stores it permanently inside `expenses.txt`

---

### Data Persistence

Unlike basic console applications, this project stores all expenses inside a file.

When the application starts again, previously saved expenses are automatically loaded into the application.

No data is lost after closing the program.

---

# 📷 Sample Menu

```
========== Expense Tracker ==========

1. Add Expense
2. View Expenses
3. Search Expense
4. Update Expense
5. Delete Expense
6. Total Spending
7. Category Report
8. Exit
```

---

# 📄 Sample Stored Data (`expenses.txt`)

```
1,Bread,Food,50.0,2026-07-11
2,Book,Study,300.0,2026-07-11
3,Coffee,Food,120.0,2026-07-11
```

---

# 🔮 Future Improvements

Planned enhancements include:

- ✅ Input Validation
- 📈 Monthly Expense Reports
- 📊 Category Analytics using HashMap
- 🔃 Sorting by Amount & Date
- 🔎 Search by Title
- 📤 Export Expense Reports
- 🗄️ Database Integration (JDBC + MySQL)
- 🖥️ GUI Version (JavaFX / Swing)

---

# 🎯 Learning Outcomes

This project helped me understand how different Java concepts work together in a real application.

Some of the key takeaways include:

- Designing applications using Object-Oriented Programming.
- Separating responsibilities into multiple classes.
- Managing objects using ArrayList.
- Working with Java File Handling for persistent storage.
- Using LocalDate for automatic date management.
- Building a complete CRUD application with clean code structure.

---

# ▶️ How to Run

### Clone the repository

```bash
git clone https://github.com/zaidshaik9014-dev/Java-Projects.git
```

### Navigate to the project

```bash
cd "Java-Projects/Expense Tracker"
```

### Compile

```bash
javac *.java
```

### Run

```bash
java Main
```

---

# 👨‍💻 Author

**Shaik Zaid**

🔗 GitHub:
https://github.com/zaidshaik9014-dev

🔗 LinkedIn:
https://www.linkedin.com/in/shaik-zaid-38a65a376

---

⭐ If you found this project interesting, consider giving the repository a star.