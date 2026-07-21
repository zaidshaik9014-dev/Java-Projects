# 🔐 Password Generator (Java)

A simple console-based Password Generator built using Java. The application allows users to generate secure passwords with different preset options or create a custom password based on their preferences. It also checks the strength of any password entered by the user.

---

## 📌 Features

- 🔑 Generate Easy Passwords
- 🔒 Generate Medium Passwords
- 🛡️ Generate Strong Passwords
- ⚙️ Generate Custom Passwords
- 💪 Check Password Strength
- ✅ Input Validation for:
  - Menu Choices
  - Password Length
  - Yes/No Inputs
- 📊 Displays Password Strength after generation

---

## 📋 Menu

```text
==============================
 PASSWORD GENERATOR
==============================

1. Easy Password
2. Medium Password
3. Strong Password
4. Custom Password
5. Check Password Strength
6. Exit
```

---

## 🔑 Password Presets

### Easy Password

- Length: 8
- Uppercase Letters ✔
- Lowercase Letters ✔
- Numbers ✔
- Symbols ✘

---

### Medium Password

- Length: 12
- Uppercase Letters ✔
- Lowercase Letters ✔
- Numbers ✔
- Symbols ✔

---

### Strong Password

- Length: 16
- Uppercase Letters ✔
- Lowercase Letters ✔
- Numbers ✔
- Symbols ✔

---

### Custom Password

The user can choose:

- Password Length (4–64)
- Include Uppercase Letters
- Include Lowercase Letters
- Include Numbers
- Include Symbols

---

## 💪 Password Strength Levels

Passwords are classified as:

- Weak
- Medium
- Strong
- Very Strong

The strength is determined based on:

- Password Length
- Uppercase Letters
- Lowercase Letters
- Numbers
- Symbols

---

## 📂 Project Structure

```text
Password-Generator/
│
├── Main.java
├── PasswordGenerator.java
├── PasswordStrength.java
├── InputHelper.java
└── README.md
```

---

## 📚 Concepts Used

- Classes & Objects
- Methods
- Method Overloading
- Static Methods
- Exception Handling
- StringBuilder
- Random
- Character Class
- Loops
- Conditional Statements
- Switch Case
- Boolean Logic
- Input Validation
- Modular Programming
- Single Responsibility Principle (Basic)

---

## ▶️ Sample Output

```text
==============================
 PASSWORD GENERATOR
==============================

1. Easy Password
2. Medium Password
3. Strong Password
4. Custom Password
5. Check Password Strength
6. Exit

Enter Choice: 2

Generated Password:
A8@kLm#2PxQ!

Strength:
Strong
```

---

## 🛠️ Technologies Used

- Java
- VS Code
- Git
- GitHub

---

## 🎯 Learning Outcomes

Through this project, I learned:

- Building menu-driven console applications
- Writing reusable methods
- Separating responsibilities using multiple classes
- Validating user input
- Generating random passwords
- Evaluating password strength
- Handling exceptions
- Writing cleaner and modular Java code

---

## 👨‍💻 Author

**Shaik Zaid**

- GitHub: https://github.com/zaidshaik9014-dev
- LinkedIn: https://www.linkedin.com/in/shaik-zaid-38a65a376

---

## ⭐ Future Improvements

Planned features for future versions:

- Guarantee every selected character type appears in the generated password
- Use `SecureRandom` instead of `Random`
- Password statistics (uppercase, lowercase, numbers, symbols count)