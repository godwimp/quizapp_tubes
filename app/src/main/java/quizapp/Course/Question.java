package main.java.quizapp.Course;
import java.util.*;
public class Question {
    private String question;
    private List<String> choices;
    private String choosedAnswer;
    private int bobotAns;
    private String correctAnswer;

    public Question(String question, List<String> choices, String correctAnswer, int bobotAns){
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.bobotAns = bobotAns;
    }
    // TODO : Link kelas dan database
    // Semua getter dan setter akan mengambil data dari database
    public String getQuestion(){
        return this.question;
    }
    public List<String> getChoices(){
        return this.choices;
    }
    public String getChoosedAnswer(){
        return this.choosedAnswer;
    }
    public int getBobotAns(){
        return this.bobotAns;
    }
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
    // SETTER tidak diperlukan, karena semuanya akan diset di konstruktor
}
