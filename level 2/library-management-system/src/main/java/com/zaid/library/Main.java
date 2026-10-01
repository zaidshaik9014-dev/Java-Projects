package com.zaid.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        IssueDAO issueDAO = new IssueDAO();

        while (true) {

            System.out.println();
            System.out.println("========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Find Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add Member");
            System.out.println("7. View All Members");
            System.out.println("8. Find Member");
            System.out.println("9. Update Member");
            System.out.println("10. Delete Member");
            System.out.println("11. Issue Book");
            System.out.println("12. Return Book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            String choiceInput = scanner.nextLine().trim();

            if (choiceInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Library Management System...");
                break;
            }

            int choice;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                // ADD BOOK
                case 1:

                    String title;

                    while (true) {
                        System.out.print("Enter book title: ");
                        title = scanner.nextLine().trim();

                        if (title.equalsIgnoreCase("exit")) {
                            System.out.println("Returning to main menu...");
                            break;
                        }

                        if (title.isEmpty()) {
                            System.out.println("Book title cannot be empty.");
                            continue;
                        }

                        break;
                    }

                    if (title.equalsIgnoreCase("exit")) {
                        break;
                    }

                    String author;

                    while (true) {
                        System.out.print("Enter author: ");
                        author = scanner.nextLine().trim();

                        if (author.equalsIgnoreCase("exit")) {
                            System.out.println("Returning to main menu...");
                            break;
                        }

                        if (author.isEmpty()) {
                            System.out.println("Author cannot be empty.");
                            continue;
                        }

                        break;
                    }

                    if (author.equalsIgnoreCase("exit")) {
                        break;
                    }

                    String category;

                    while (true) {
                        System.out.print("Enter category: ");
                        category = scanner.nextLine().trim();

                        if (category.equalsIgnoreCase("exit")) {
                            System.out.println("Returning to main menu...");
                            break;
                        }

                        if (category.isEmpty()) {
                            System.out.println("Category cannot be empty.");
                            continue;
                        }

                        break;
                    }

                    if (category.equalsIgnoreCase("exit")) {
                        break;
                    }

                    Book book = new Book(
                            title,
                            author,
                            category
                    );

                    bookDAO.addBook(book);
                    break;


                // VIEW ALL BOOKS
                case 2:

                    bookDAO.viewAllBooks();
                    break;


                // FIND BOOK
                case 3:

                    System.out.print("Enter book ID: ");
                    String bookIdInput = scanner.nextLine().trim();

                    if (bookIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    try {

                        int bookId = Integer.parseInt(bookIdInput);

                        bookDAO.findBookById(bookId);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid book ID.");
                    }

                    break;


                // UPDATE BOOK
                case 4:

                    System.out.print("Enter book ID: ");
                    String updateBookIdInput =
                            scanner.nextLine().trim();

                    if (updateBookIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    int updateBookId;

                    try {

                        updateBookId =
                                Integer.parseInt(updateBookIdInput);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid book ID.");
                        break;
                    }

                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine().trim();

                    if (newTitle.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (newTitle.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine().trim();

                    if (newAuthor.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (newAuthor.isEmpty()) {
                        System.out.println("Author cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine().trim();

                    if (newCategory.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (newCategory.isEmpty()) {
                        System.out.println("Category cannot be empty.");
                        break;
                    }

                    bookDAO.updateBook(
                            updateBookId,
                            newTitle,
                            newAuthor,
                            newCategory
                    );

                    break;


                // DELETE BOOK
                case 5:

                    System.out.print("Enter book ID: ");
                    String deleteBookIdInput =
                            scanner.nextLine().trim();

                    if (deleteBookIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    try {

                        int deleteBookId =
                                Integer.parseInt(deleteBookIdInput);

                        bookDAO.deleteBook(deleteBookId);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid book ID.");
                    }

                    break;


                // ADD MEMBER
                case 6:

                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine().trim();

                    if (name.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine().trim();

                    if (email.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (email.isEmpty()) {
                        System.out.println("Email cannot be empty.");
                        break;
                    }

                    String phone;

                    while (true) {

                        System.out.print("Enter phone number: ");
                        phone = scanner.nextLine().trim();

                        if (phone.equalsIgnoreCase("exit")) {
                            System.out.println("Returning to main menu...");
                            break;
                        }

                        if (!phone.matches("\\d{10}")) {
                            System.out.println(
                                    "Phone number must contain exactly 10 digits."
                            );
                            continue;
                        }

                        break;
                    }

                    if (phone.equalsIgnoreCase("exit")) {
                        break;
                    }

                    Member member = new Member(
                            name,
                            email,
                            phone
                    );

                    memberDAO.addMember(member);
                    break;


                // VIEW ALL MEMBERS
                case 7:

                    memberDAO.viewAllMembers();
                    break;


                // FIND MEMBER
                case 8:

                    System.out.print("Enter member ID: ");
                    String memberIdInput =
                            scanner.nextLine().trim();

                    if (memberIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    try {

                        int memberId =
                                Integer.parseInt(memberIdInput);

                        memberDAO.findMemberById(memberId);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid member ID.");
                    }

                    break;


                // UPDATE MEMBER
                case 9:

                    System.out.print("Enter member ID: ");
                    String updateMemberIdInput =
                            scanner.nextLine().trim();

                    if (updateMemberIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    int updateMemberId;

                    try {

                        updateMemberId =
                                Integer.parseInt(updateMemberIdInput);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid member ID.");
                        break;
                    }

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine().trim();

                    if (newName.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (newName.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine().trim();

                    if (newEmail.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (newEmail.isEmpty()) {
                        System.out.println("Email cannot be empty.");
                        break;
                    }

                    String newPhone;

                    while (true) {

                        System.out.print("Enter new phone number: ");
                        newPhone = scanner.nextLine().trim();

                        if (newPhone.equalsIgnoreCase("exit")) {
                            System.out.println("Returning to main menu...");
                            break;
                        }

                        if (!newPhone.matches("\\d{10}")) {
                            System.out.println(
                                    "Phone number must contain exactly 10 digits."
                            );
                            continue;
                        }

                        break;
                    }

                    if (newPhone.equalsIgnoreCase("exit")) {
                        break;
                    }

                    memberDAO.updateMember(
                            updateMemberId,
                            newName,
                            newEmail,
                            newPhone
                    );

                    break;


                // DELETE MEMBER
                case 10:

                    System.out.print("Enter member ID: ");
                    String deleteMemberIdInput =
                            scanner.nextLine().trim();

                    if (deleteMemberIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    try {

                        int deleteMemberId =
                                Integer.parseInt(deleteMemberIdInput);

                        memberDAO.deleteMember(deleteMemberId);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid member ID.");
                    }

                    break;


                // ISSUE BOOK
                case 11:

                    System.out.print("Enter book ID: ");
                    String issueBookIdInput =
                            scanner.nextLine().trim();

                    if (issueBookIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    int issueBookId;

                    try {

                        issueBookId =
                                Integer.parseInt(issueBookIdInput);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid book ID.");
                        break;
                    }

                    System.out.print("Enter member ID: ");
                    String issueMemberIdInput =
                            scanner.nextLine().trim();

                    if (issueMemberIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    int issueMemberId;

                    try {

                        issueMemberId =
                                Integer.parseInt(issueMemberIdInput);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid member ID.");
                        break;
                    }

                    issueDAO.issueBook(
                            issueBookId,
                            issueMemberId
                    );

                    break;


                // RETURN BOOK
                case 12:

                    System.out.print("Enter book ID: ");
                    String returnBookIdInput =
                            scanner.nextLine().trim();

                    if (returnBookIdInput.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    try {

                        int returnBookId =
                                Integer.parseInt(returnBookIdInput);

                        issueDAO.returnBook(returnBookId);

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid book ID.");
                    }

                    break;


                // EXIT
                case 0:

                    System.out.println(
                            "Exiting Library Management System..."
                    );

                    scanner.close();
                    return;


                default:

                    System.out.println(
                            "Invalid choice. Try again."
                    );
            }
        }

        scanner.close();
    }
}