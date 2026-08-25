package com.zaid.studentmanagement.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     DBConfig.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IOException("config.properties not found");
            }

            properties.load(input);

        } catch (IOException e) {
            System.out.println("Could not load database configuration.");
            e.printStackTrace();
        }
    }

    public static final String URL =
            properties.getProperty("db.url");

    public static final String USER =
            properties.getProperty("db.user");

    public static final String PASSWORD =
            properties.getProperty("db.password");
}