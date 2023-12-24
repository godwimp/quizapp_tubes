package main.java.quizapp;
import java.sql.*;

import main.java.quizapp.Client.Mahasiswa;
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
    public static void showMhs(){
        String sql = "SELECT * FROM user WHERE role = 'mahasiswa'";
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) { 
                while(rs.next()){
                    String nim = rs.getString("identnum");
                    String nama = rs.getString("fullname");
                    System.out.println("NIM : " + nim + " Nama : " + nama);
                }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showDosen(){
        String sql = "SELECT * FROM user WHERE role = 'dosen'";
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) { 
                while(rs.next()){
                    String nip = rs.getString("identnum");
                    String nama = rs.getString("fullname");
                    System.out.println("NIP : " + nip + " Nama : " + nama);
                }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addMahasiswa(Mahasiswa m){
        String sql = "INSERT INTO user (id, identnum, fullname, username, password, role) VALUES (NULL, ?, ?, ?, MD5(?), ?)";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(2, m.getNIM());
                stmt.setString(3, m.getFullname());
                stmt.setString(4, m.getUsername());
                stmt.setString(5, m.getPassword());
                stmt.setString(6, "Mahasiswa");
                stmt.executeUpdate();
                System.out.println("Mahasiswa berhasil ditambahkan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addDosen(Dosen d){
        String sql = "INSERT INTO user (id, identnum, fullname, username, password, role) VALUES (NULL, ?, ?, ?, MD5(?), ?)";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(2, d.getNIP());
                stmt.setString(3, d.getFullname());
                stmt.setString(4, d.getUsername());
                stmt.setString(5, d.getPassword());
                stmt.setString(6, "Dosen");
                stmt.executeUpdate();
                System.out.println("Dosen berhasil ditambahkan");
        }
    }
    public static int getNMahasiswa(){
        String sql = "SELECT COUNT(*) FROM user WHERE role = 'mahasiswa'";
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) { 
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int getNDosen(){
        String sql = "SELECT COUNT(*) FROM user WHERE role = 'dosen'";
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) { 
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
