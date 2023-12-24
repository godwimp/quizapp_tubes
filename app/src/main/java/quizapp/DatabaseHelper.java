package main.java.quizapp;
import java.sql.*;
public class DatabaseHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/quizapp_pbo";
    private static final String USERNAME = "quizdba";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
    public static boolean validateLogin(String username, String password){
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    // TODO : tambahkan method yang diperlukan yang berhubungan dengan database
}
