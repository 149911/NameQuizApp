package no.hvl.dat153.namequizapp.logic;

import android.app.Application;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends Application {

    private String question;
    private String correctAnswer;
    private ArrayList<String> alternatives;
    private Random random = new Random();
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    public Quiz (String question, String correctAnswer, ArrayList<String> alternatives) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.alternatives = alternatives;
    }

    public Quiz() {

    }

    /*
    This method has to make new question up until wrong answer
    return resultpage
     */
    public void playQuiz() {
    }

    /*
    This method creates question
     */
    public int makeQuestion(ArrayList<String> possibleQuestions) {

        int randomId = random.nextInt(possibleQuestions.size());

       // String question = possibleQuestions.get(randomId);

        return randomId;
    }

    /**
     * Setting correct answer to random textview, then fill the remaining textviews with random answers from the possibleAnswers list.
     * @param possibleAnswers
     * @param correctAnswer
     * @param textViews
     */
    public void randomizeAnswers(ArrayList<String> possibleAnswers, String correctAnswer, ArrayList<TextView> textViews) {
        ArrayList<String> temp = possibleAnswers;
        ArrayList<TextView> tempTv = textViews;
        int randomId = random.nextInt(3);
        tempTv.get(randomId).setText(correctAnswer);

        tempTv.remove(randomId);
        temp.remove(correctAnswer);

        for (TextView tv : tempTv) {
            randomId = random.nextInt(temp.size());
            tv.setText(temp.get(randomId));
            temp.remove(randomId);
        }

    }

}
