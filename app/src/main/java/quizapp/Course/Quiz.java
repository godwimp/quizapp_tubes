package main.java.quizapp.Course;
import java.util.*;

import javax.xml.crypto.Data;

import main.java.quizapp.DatabaseHelper;
public class Quiz {
    private List<Question> questions;
    private int nQuestion;

    public Quiz(List<Question> questions, int nQuestion){
        this.questions = questions;
        this.nQuestion = nQuestion;
    }
    // TODO : Link kelas dan database
    // Semua getter dan setter akan mengambil data dari database
    public List<Question> getQuestions(){
        return DatabaseHelper.getQuestions();
    }
    public int getNQuestion(){
        return DatabaseHelper.getNQuestion();
    }
    public void setQuestions(List<Question> questions){
        DatabaseHelper.setQuestions(questions);
    }
}
