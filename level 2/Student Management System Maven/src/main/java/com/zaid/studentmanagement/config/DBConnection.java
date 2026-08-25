package com.zaid.studentmanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Connection connection = DriverManager.getConnection(
                    DBConfig.URL,
                    DBConfig.USER,
                    DBConfig.PASSWORD
            );

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed.");
            e.printStackTrace();

            return null;
        }
    }
}