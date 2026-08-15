package dao;

import config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

public class StudentDAO {

    public boolean addStudent(Student student) {

        String query = """
                INSERT INTO students
                (name, age, branch, email, phone)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(query);
        )    {

            statement.setString(1, student.getName());

            statement.setInt(2, student.getAge());

            statement.setString(3, student.getBranch());

            statement.setString(4, student.getEmail());

            statement.setString(5, student.getPhone());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            if (e.getMessage().contains("Duplicate entry")) {

                System.out.println("Email or phone number already exists.");

            } else {

                System.out.println("Database error: " + e.getMessage());
            }

            return false;
        }

    }

    public ArrayList<Student> getAllStudents() {

    ArrayList<Student> students = new ArrayList<>();

    String query = "SELECT * FROM students";

    try (
        
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement =
                connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        
    ) {

        while (resultSet.next()) {

            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setBranch(resultSet.getString("branch"));
            student.setEmail(resultSet.getString("email"));
            student.setPhone(resultSet.getString("phone"));

            students.add(student);

        }

    } catch (SQLException e) {

        e.printStackTrace();

    }

        return students;

    }

    public boolean updateStudent(Student student) {

    String query = """
            UPDATE students
            SET name = ?,
                age = ?,
                branch = ?,
                email = ?,
                phone = ?
            WHERE id = ?
            """;

    try (
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement =
                connection.prepareStatement(query);  
        
    ) {

        statement.setString(1, student.getName());

        statement.setInt(2, student.getAge());

        statement.setString(3, student.getBranch());

        statement.setString(4, student.getEmail());

        statement.setString(5, student.getPhone());

        statement.setInt(6, student.getId());

        int rowsAffected = statement.executeUpdate();

        return rowsAffected > 0;

    } catch (SQLException e) {

        e.printStackTrace();

        return false;

    }

    }

    public boolean deleteStudent(int id) {

    String query = """
            DELETE FROM students
            WHERE id = ?
            """;

    try (
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement =
                connection.prepareStatement(query);
        
    ) {

        statement.setInt(1, id);

        int rowsAffected = statement.executeUpdate();

        return rowsAffected > 0;

    } catch (SQLException e) {

        e.printStackTrace();

        return false;
    }
}

public Student getStudentById(int id) {

    String query = "SELECT * FROM students WHERE id = ?";

    try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
                connection.prepareStatement(query)
    ) {

        statement.setInt(1, id);

        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setBranch(resultSet.getString("branch"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));

                return student;
            }
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return null;
}

}