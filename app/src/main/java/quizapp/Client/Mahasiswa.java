package main.java.quizapp.Client;
import java.util.*;

public class Mahasiswa extends User{
    private int nim;
    private List<Nilai> listNilai;
    public Mahasiswa(String fullname, String username, String password, String nim) {
        super(fullname, username, password);
        this.nim = nim;
    }
    @Override
    protected boolean login(String username, String password){
        return DatabaseHelper.validateLogin(username, password);
    }
    public String getNIM(){
        return this.nim;
    }
    public String getFullname(){
        return super.getFullname();
    }
    public void takeQuiz(){
        // ambil quiz dari database, quiz ditampilkan di GUI dengan cara menampilkan soal dan pilihan jawaban
    }
    public void submitQuiz(){
        // submit jawaban ke database, pada setiap soal akan ada pilihan jawaban yang dipilih
    }
    public void showNilai(){
        // show nilai dari database
    }
    public List<Nilai> getListNilai(){
        return this.listNilai;
    }
}
