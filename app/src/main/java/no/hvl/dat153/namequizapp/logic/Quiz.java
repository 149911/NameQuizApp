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
    public void makeQuiz() {

    }

    /*
    This method creates question with alternatives
     */
    public String makeQuestion(ArrayList<String> possibleQuestions) {

        int randomId = random.nextInt(possibleQuestions.size());

        String question = possibleQuestions.get(randomId);

        return question;
    }

    /**
     * Setting correct answer to random textview, then fill the remaining textviews with random answers from the possibleAnswers list.
     * @param possibleAnswers
     * @param correctAnswer
     * @param textViews
     */
    public void randomizeAnswers(ArrayList<String> possibleAnswers, String correctAnswer, ArrayList<TextView> textViews) {
        int randomId = random.nextInt(textViews.size());
        textViews.get(randomId).setText(correctAnswer);

        textViews.remove(randomId);
        possibleAnswers.remove(correctAnswer);

        for (TextView tv : textViews) {
            randomId = random.nextInt(possibleAnswers.size());
            tv.setText(possibleAnswers.get(randomId));
            possibleAnswers.remove(randomId);
        }
    }

    /*
    Check if clicked name is correct
    return true if correct
    return false if wrong
     */
    public boolean checkAnswer(String correctAnswer, String guess) {
        if (correctAnswer.equals(guess)) {
            return true;
        }
        return false;
    }

}
