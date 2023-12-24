package main.java.quizapp.Client;

import main.java.quizapp.DatabaseHelper;
import main.java.quizapp.Course.Quiz;

public class Dosen extends User implements Observable{
    private String NIP;
    public Dosen(String fullname, String username, String password, String NIP) {
        super(fullname, username, password);
        this.NIP = NIP;
    }
    protected boolean login(String username, String password){
        return DatabaseHelper.validateLogin(username, password);
    }
    public void createQuestion(Quiz q){
        // add question to database
    }
    public void showQuestion(Quiz q){
        // show question from database
    }
    public void editQuestion(Quiz q){
        //edit question from database
    }
    public void deleteQuestion(Quiz q){
        // delete question from database
    }
    public void showMhs(){
        // show mahasiswa dari database
    }
    public void showNilaiMhs(Mahasiswa m, Quiz q){
        // show nilai mahasiswa dari database
    }
}
