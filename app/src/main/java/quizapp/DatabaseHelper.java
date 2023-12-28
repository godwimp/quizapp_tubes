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
    public static List<Question> getQuestions(){
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * from quiz";
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while(rs.next()){
                    int questionId = rs.getInt("questionid");
                    String question = rs.getString("question");
                    String choice1 = rs.getString("choice1");
                    String choice2 = rs.getString("choice2");
                    String choice3 = rs.getString("choice3");
                    String choice4 = rs.getString("choice4");
                    String realAnswer = rs.getString("realanswer");
                    int bobot = rs.getInt("bobot");
                    List<String> choices = new ArrayList<>();
                    choices.add(choice1);
                    choices.add(choice2);
                    choices.add(choice3);
                    choices.add(choice4);
                    Question q = new Question(questionId, question, choices, realAnswer, bobot);
                    questions.add(q);
                }
        } catch(Exception e){
            e.printStackTrace();
        }
        return questions;
    }
    public static int getNQuestion(){
        String sql = "SELECT COUNT(*) FROM quiz";
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                if(rs.next()){
                    return rs.getInt(1);
                }
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static void setQuestions(List<Question> questions){
        String sql = "INSERT INTO quiz (questionid, question, choice1, choice2, choice3, choice4, realanswer, bobot) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
                for(Question q : questions){
                    stmt.setString(2, q.getQuestion());
                    List<String> choices = q.getChoices();
                    stmt.setString(3, choices.get(0));
                    stmt.setString(4, choices.get(1));
                    stmt.setString(5, choices.get(2));
                    stmt.setString(6, choices.get(3));
                    stmt.setString(7, q.getRealAnswer());
                    stmt.setInt(8, q.getBobot());
                    stmt.executeUpdate();
                }
                System.out.println("Soal berhasil ditambahkan");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
