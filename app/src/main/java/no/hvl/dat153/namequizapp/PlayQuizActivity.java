package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import no.hvl.dat153.namequizapp.logic.Database;
import no.hvl.dat153.namequizapp.logic.Quiz;

public class PlayQuizActivity extends AppCompatActivity {

    private ImageView imageView;
    private ArrayList<TextView> textViews = new ArrayList<>();

    private String correctAnswer;
    private ArrayList<String> possibleAnswers = new ArrayList<>();
    private Quiz q = new Quiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        imageView = findViewById(R.id.imageQuiz);
        TextView alt1 = findViewById(R.id.alt1);
        TextView alt2 = findViewById(R.id.alt2);
        TextView alt3 = findViewById(R.id.alt3);
        TextView alt4 = findViewById(R.id.alt4);

        textViews.add(alt1);
        textViews.add(alt2);
        textViews.add(alt3);
        textViews.add(alt4);

        setPossibleAnswers();
        makeQuestionAgain(q);

    }

    private void setPossibleAnswers() {
        ((Database) getApplication()).getClassmatesDB().forEach(name -> possibleAnswers.add(name.getName()));
    }

    public void userGuess(View v) {
        correctGuess(v, correctAnswer);
    }

    public boolean correctGuess (View v, String correctAnswer) {
        int numberOfCorrect = 0;
        boolean isCorrect = false;
        String guess = ((TextView) v).getText().toString();
        if (correctAnswer.equals(guess)) {
            isCorrect = true;
            startActivity(new Intent(PlayQuizActivity.this, PlayQuizActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            overridePendingTransition(0,0);
            ((Database) getApplication()).increaseInt();
        } else {
            Toast.makeText(PlayQuizActivity.this, "Correct was: " + correctAnswer, Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor sp = getSharedPreferences("no.hvl.dat153.namequizapp", MODE_PRIVATE).edit();
            sp.putInt("numberofcorrect", ((Database) getApplication()).getInt());
            sp.putString("correctAnswer", correctAnswer);
            sp.putString("guess", guess);
            sp.apply();
            startActivity(new Intent(this, ResultActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        return isCorrect;
    }

    public void makeQuestionAgain(Quiz q) {
        int indexOfCorrectAnswer = q.makeQuestion(possibleAnswers);
        Bitmap bm = (((Database) getApplication()).getClassmatesDB().get(indexOfCorrectAnswer).getImage());
        correctAnswer = ((Database) getApplication()).getClassmatesDB().get(indexOfCorrectAnswer).getName();

        imageView.setImageBitmap(bm);
        q.randomizeAnswers(possibleAnswers, correctAnswer, textViews);
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return false;
    }

}