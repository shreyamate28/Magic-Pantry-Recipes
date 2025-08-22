package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/MagicPantryDB?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";  // Your MySQL username
    private static final String PASSWORD = "root"; // Your MySQL password

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
            return null;
        }
    }
}
