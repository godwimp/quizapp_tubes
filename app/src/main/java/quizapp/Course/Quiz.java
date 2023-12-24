package main.java.quizapp.Course;
import java.util.*;
public class Quiz {
    private List<Question> questions;
    private int nQuestion;

    public Quiz(List<Question> questions, int nQuestion){
        this.questions = questions;
        this.nQuestion = nQuestion;
    }
    // Semua getter dan setter akan mengambil data dari database
    public List<Question> getQuestions(){
        return this.questions;
    }
    public int getNQuestion(){
        return this.nQuestion;
    }
    public void setQuestions(List<Question> questions){
        this.questions = questions;
    }
}
