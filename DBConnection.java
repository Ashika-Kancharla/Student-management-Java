import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String user = "root";
            String password = "your_password"; // replace with your actual password
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }
}
