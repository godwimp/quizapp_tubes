package main.java.quizapp.Client;

import main.java.quizapp.DatabaseHelper;

public class Admin extends User implements Observable{

    public Admin(String fullname, String username, String password) {
        super(fullname, username, password);
    }
    @Override
    protected boolean login(String username, String password){
        return DatabaseHelper.validateLogin(username, password);
    }
    @Override
    public void showMhs(){
        // show mahasiswa dari database
    }
    public void showDosen(){
        // show dosen dari database
    }
    public void addMahasiswa(Mahasiswa m){
        // add mahasiswa to database
    }
    public void AddDosen(Dosen d){
        // add dosen to database
    }
    public int getNMahasiswa(){
        return 0;
    }
    public int getNDosen(){
        return 0;
    }
    // TODO : lengkapi semua method
}
