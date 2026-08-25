package com.zaid.studentmanagement.app;

import java.util.ArrayList;

import com.zaid.studentmanagement.dao.StudentDAO;
import com.zaid.studentmanagement.helper.InputHelper;
import com.zaid.studentmanagement.helper.UserCancelledException;
import com.zaid.studentmanagement.model.Student;

public class Main {

    private static void addStudent(StudentDAO dao) {

        System.out.println("\n===== Add Student =====");

        String name =
                InputHelper.getNonEmptyString("Enter name: ");

        int age =
                InputHelper.getAge("Enter age: ");

        String branch =
                InputHelper.getNonEmptyString("Enter branch: ");

        String email =
                InputHelper.getEmail("Enter email: ");

        String phone =
                InputHelper.getPhone("Enter phone: ");

        Student student = new Student(
                0,
                name,
                age,
                branch,
                email,
                phone
        );

        if (dao.addStudent(student)) {

            System.out.println("Student Added Successfully!");

        } else {

            System.out.println("Failed to Add Student.");
        }
    }

    private static void viewStudents(StudentDAO dao) {

        System.out.println("\n===== All Students =====");

        ArrayList<Student> students =
                dao.getAllStudents();

        if (students.isEmpty()) {

            System.out.println("No students found.");

            return;
        }

        for (Student student : students) {

            System.out.println("ID     : " + student.getId());
            System.out.println("Name   : " + student.getName());
            System.out.println("Age    : " + student.getAge());
            System.out.println("Branch : " + student.getBranch());
            System.out.println("Email  : " + student.getEmail());
            System.out.println("Phone  : " + student.getPhone());

            System.out.println("----------------------------");
        }
    }

    private static void updateStudent(StudentDAO dao) {

        System.out.println("\n===== Update Student =====");

        int id =
                InputHelper.getStudentId("Enter student ID: ");

        String name =
                InputHelper.getNonEmptyString("Enter new name: ");

        int age =
                InputHelper.getAge("Enter new age: ");

        String branch =
                InputHelper.getNonEmptyString("Enter new branch: ");

        String email =
                InputHelper.getEmail("Enter new email: ");

        String phone =
                InputHelper.getPhone("Enter new phone: ");

        Student student = new Student(
                id,
                name,
                age,
                branch,
                email,
                phone
        );

        if (dao.updateStudent(student)) {

            System.out.println("Student Updated Successfully!");

        } else {

            System.out.println("No student found with ID " + id + ".");
        }
    }

    private static void deleteStudent(StudentDAO dao) {

        System.out.println("\n===== Delete Student =====");

        int id =
                InputHelper.getStudentId("Enter student ID: ");

        boolean confirm =
                InputHelper.getYesNo(
                        "Are you sure you want to delete this student? (yes/no): "
                );

        if (!confirm) {

           System.out.println("Delete cancelled.");

            return;
        }

        if (dao.deleteStudent(id)) {

            System.out.println("Student Deleted Successfully!");

        } else {

            System.out.println("No student found with ID " + id + ".");
        }
    }

    private static void searchStudent(StudentDAO dao) {

        System.out.println("\n===== Search Student =====");

        int id =
                InputHelper.getStudentId("Enter student ID: ");

        Student student =
                dao.getStudentById(id);

        if (student == null) {

            System.out.println(
                   "No student found with ID " + id + "."
            );

            return;
        }

        System.out.println("ID     : " + student.getId());
        System.out.println("Name   : " + student.getName());
        System.out.println("Age    : " + student.getAge());
        System.out.println("Branch : " + student.getBranch());
        System.out.println("Email  : " + student.getEmail());
        System.out.println("Phone  : " + student.getPhone());
    }

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.println("================================");

        try {

            int choice = InputHelper.getInt("Enter choice: ");

                switch (choice) {

                    case 1:
                        addStudent(dao);
                        break;
                    
                    case 2:
                        viewStudents(dao);
                        break;

                    case 3:
                        updateStudent(dao);
                        break;

                    case 4:
                        deleteStudent(dao);
                        break;

                    case 5:
                        searchStudent(dao);
                        break;

                    case 6:
                        System.out.println("Thank you for using Student Management System!");
                        return;

                    default:
                        System.out.println("Invalid choice. Enter 1-6.");
                }

            } catch (UserCancelledException e) {

                System.out.println("\nOperation cancelled.");
            }
        }
    }
}