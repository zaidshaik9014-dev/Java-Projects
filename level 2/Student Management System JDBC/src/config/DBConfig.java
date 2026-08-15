package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {

    private static final Properties properties = new Properties();

    static {

        try (FileInputStream file =
                     new FileInputStream("config.properties")) {

            properties.load(file);

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