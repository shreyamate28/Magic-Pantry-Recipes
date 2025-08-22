package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/recipe_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";  // Your MySQL username
    private static final String PASSWORD = "root"; // Your MySQL password

    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish and return the connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
            return conn;
        } catch (Exception e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
            return null;
        }
    }
}
