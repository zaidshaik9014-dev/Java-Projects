package com.zaid.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    // ADD BOOK
    public void addBook(Book book) {

        String sql =
                "INSERT INTO books (title, author, category, available) " +
                "VALUES (?, ?, ?, ?)";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setBoolean(4, book.isAvailable());

            ps.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL BOOKS
    public void viewAllBooks() {

        String sql = "SELECT * FROM books";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println();
            System.out.println(
                    "--------------------------------------------------------------------------"
            );

            System.out.printf(
                    "%-5s %-30s %-25s %-18s %-10s%n",
                    "ID",
                    "TITLE",
                    "AUTHOR",
                    "CATEGORY",
                    "AVAILABLE"
            );

            System.out.println(
                    "--------------------------------------------------------------------------"
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String category = rs.getString("category");
                boolean available = rs.getBoolean("available");

                System.out.printf(
                        "%-5d %-30s %-25s %-18s %-10s%n",
                        id,
                        title,
                        author,
                        category,
                        available ? "Yes" : "No"
                );
            }

            if (!found) {
                System.out.println("No books found.");
            }

            System.out.println(
                    "--------------------------------------------------------------------------"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND BOOK BY ID
    public void findBookById(int id) {

        String sql = "SELECT * FROM books WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println();
                    System.out.println("Book Details");
                    System.out.println("-------------------------");

                    System.out.println(
                            "ID: " + rs.getInt("id")
                    );

                    System.out.println(
                            "Title: " + rs.getString("title")
                    );

                    System.out.println(
                            "Author: " + rs.getString("author")
                    );

                    System.out.println(
                            "Category: " + rs.getString("category")
                    );

                    System.out.println(
                            "Available: " +
                            (rs.getBoolean("available")
                                    ? "Yes"
                                    : "No")
                    );

                } else {

                    System.out.println("Book not found.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE BOOK
    public void updateBook(
            int id,
            String title,
            String author,
            String category) {

        String sql =
                "UPDATE books " +
                "SET title = ?, author = ?, category = ? " +
                "WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, category);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(
                        "Book updated successfully!"
                );
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE BOOK
    public void deleteBook(int id) {

        String sql = "DELETE FROM books WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(
                        "Book deleted successfully!"
                );
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}