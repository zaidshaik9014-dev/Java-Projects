package com.zaid.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    // ADD MEMBER
    public void addMember(Member member) {

        String sql =
                "INSERT INTO members (name, email, phone) " +
                "VALUES (?, ?, ?)";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());

            ps.executeUpdate();

            System.out.println("Member added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // VIEW ALL MEMBERS
    public void viewAllMembers() {

        String sql = "SELECT * FROM members";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                System.out.println(
                        id + " | " +
                        name + " | " +
                        email + " | " +
                        phone
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // FIND MEMBER BY ID
    public void findMemberById(int id) {

        String sql = "SELECT * FROM members WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println("ID: " +
                            rs.getInt("id"));

                    System.out.println("Name: " +
                            rs.getString("name"));

                    System.out.println("Email: " +
                            rs.getString("email"));

                    System.out.println("Phone: " +
                            rs.getString("phone"));

                } else {

                    System.out.println("Member not found.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // UPDATE MEMBER
    public void updateMember(int id, String name,
                             String email, String phone) {

        String sql =
                "UPDATE members " +
                "SET name = ?, email = ?, phone = ? " +
                "WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Member updated successfully!");
            } else {
                System.out.println("Member not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // DELETE MEMBER
    public void deleteMember(int id) {

        String sql = "DELETE FROM members WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Member deleted successfully!");
            } else {
                System.out.println("Member not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}