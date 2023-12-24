package main.java.quizapp.Client;
import java.util.*;

public abstract class User {
    private String fullname;
    private String username;
    private String password;

    public User(String fullname, String username, String password){
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }
    protected abstract boolean login(String username, String password);
    protected void logout(){
        // logout user, implementasinya nanti di GUI dengan cara logout dan kembali ke halaman login
    }
    public String getFullname(){
        return this.fullname;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
