# Student Management System

A console-based Student Management System built using Java, JDBC, and MySQL.

The project demonstrates how a Java application can connect to a relational database and perform CRUD operations using the DAO design pattern.

---

## Features

- Add a new student
- View all students
- Search student by ID
- Update student information
- Delete a student
- Delete confirmation
- Input validation
- Age validation
- Email validation
- Phone number validation
- Student ID validation
- Duplicate email and phone handling
- JDBC resource management
- MySQL database integration

---

## Technologies Used

- Java
- JDBC
- MySQL
- MySQL Workbench
- VS Code
- Git & GitHub

---

## Project Architecture

The project follows a simple layered structure.

```text
User
  |
  v
Main.java
  |
  +----> InputHelper
  |
  +----> Student Model
  |
  v
StudentDAO
  |
  v
DBConnection
  |
  v
MySQL Database

PROJECT STRUCTURE

Student Management System JDBC
|
├── .gitignore
├── README.md
├── config.properties
|
├── lib
|   └── mysql-connector-j-26.7.0.jar
|
├── sql
|   └── database.sql
|
└── src
    |
    ├── app
    |   └── Main.java
    |
    ├── config
    |   ├── DBConfig.java
    |   └── DBConnection.java
    |
    ├── dao
    |   └── StudentDAO.java
    |
    ├── helper
    |   └── InputHelper.java
    |
    └── model
        └── Student.java