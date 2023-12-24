package main.java.quizapp.Client;

import javax.xml.crypto.Data;

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
        DatabaseHelper.showMhs();
    }
    public void showDosen(){
        DatabaseHelper.showDosen();
    }
    public void addMahasiswa(Mahasiswa m){
        DatabaseHelper.addMahasiswa(m);
    }
    public void AddDosen(Dosen d){
        DatabaseHelper.addDosen(d);
    }
    public int getNMahasiswa(){
        return DatabaseHelper.getNMahasiswa();
    }
    public int getNDosen(){
        return DatabaseHelper.getNDosen();
    }
}
