package com.zaid.library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueDAO {

    // ISSUE BOOK
    public void issueBook(int bookId, int memberId) {

        String checkBook =
                "SELECT available FROM books WHERE id = ?";

        String checkMember =
                "SELECT id FROM members WHERE id = ?";

        String insertIssue =
                "INSERT INTO issued_books " +
                "(book_id, member_id, issue_date) " +
                "VALUES (?, ?, ?)";

        String updateBook =
                "UPDATE books SET available = false WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection()
        ) {

            connection.setAutoCommit(false);

            try (PreparedStatement ps =
                    connection.prepareStatement(checkBook)) {

                ps.setInt(1, bookId);

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Book not found.");
                        connection.rollback();
                        return;
                    }

                    if (!rs.getBoolean("available")) {
                        System.out.println("Book is already issued.");
                        connection.rollback();
                        return;
                    }
                }
            }

            try (PreparedStatement ps =
                    connection.prepareStatement(checkMember)) {

                ps.setInt(1, memberId);

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Member not found.");
                        connection.rollback();
                        return;
                    }
                }
            }

            try (PreparedStatement ps =
                    connection.prepareStatement(insertIssue)) {

                ps.setInt(1, bookId);
                ps.setInt(2, memberId);
                ps.setDate(3, new Date(System.currentTimeMillis()));

                ps.executeUpdate();
            }

            try (PreparedStatement ps =
                    connection.prepareStatement(updateBook)) {

                ps.setInt(1, bookId);

                ps.executeUpdate();
            }

            connection.commit();

            System.out.println("Book issued successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // RETURN BOOK
    public void returnBook(int bookId) {

        String findIssue =
                "SELECT id FROM issued_books " +
                "WHERE book_id = ? AND return_date IS NULL";

        String updateIssue =
                "UPDATE issued_books " +
                "SET return_date = ? " +
                "WHERE id = ?";

        String updateBook =
                "UPDATE books SET available = true " +
                "WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection()
        ) {

            connection.setAutoCommit(false);

            int issueId;

            // FIND ACTIVE ISSUE
            try (PreparedStatement ps =
                    connection.prepareStatement(findIssue)) {

                ps.setInt(1, bookId);

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println(
                                "No active issue found for this book."
                        );

                        connection.rollback();
                        return;
                    }

                    issueId = rs.getInt("id");
                }
            }

            // SET RETURN DATE
            try (PreparedStatement ps =
                    connection.prepareStatement(updateIssue)) {

                ps.setDate(
                        1,
                        new Date(System.currentTimeMillis())
                );

                ps.setInt(2, issueId);

                ps.executeUpdate();
            }

            // MAKE BOOK AVAILABLE
            try (PreparedStatement ps =
                    connection.prepareStatement(updateBook)) {

                ps.setInt(1, bookId);

                ps.executeUpdate();
            }

            connection.commit();

            System.out.println("Book returned successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}