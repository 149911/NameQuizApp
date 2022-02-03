package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import no.hvl.dat153.namequizapp.logic.Database;

public class PlayQuizActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private TextView alt1;
    private TextView alt2;
    private int numberOfCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        //db.setClassmatesDB( ((Database) getApplication()).getClassmatesDB() );


        View view = new View(getApplicationContext());
        correctOrWrong(view);

    }

    public String generateQuestionWithAnswer() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(((Database) getApplication()).getClassmatesDB().size());

        String question = ((Database) getApplication()).getClassmatesDB().get(randomIndex).getName();
        imageView = findViewById(R.id.imageQuiz);
        imageView.setImageDrawable(makeDrawable(question));

        alt1 = findViewById(R.id.alt1);
        alt2 = findViewById(R.id.alt2);

        alt1.setText(question);

        ArrayList<String> alt = new ArrayList<>();
        ((Database) getApplication()).getClassmatesDB().forEach(p -> alt.add(p.getName()));

        Random rand2 = new Random();
        int randomIndex2 = rand2.nextInt(alt.size());
        String alternative2 = alt.get(randomIndex2);

        if (randomIndex == randomIndex2) {
            if (randomIndex2 == 0) {
                randomIndex2++;
            } else {
                randomIndex2--;
            }
            alternative2 = alt.get(randomIndex2);
        }
        alt2.setText(alternative2);

        return question;

    }


    public void correctOrWrong(View v) {
        String correctAnswer = generateQuestionWithAnswer();
        alt1 = findViewById(R.id.alt1);
        alt2 = findViewById(R.id.alt2);
        SharedPreferences sharedPreferences = this.getSharedPreferences("no.hvl.dat153.namequizapp", MODE_PRIVATE);
        Intent launchActivity = new Intent(PlayQuizActivity.this, ResultActivity.class);

        if (alt1.getId() == v.getId()) {
            if (alt1.getText().equals(correctAnswer) ) {
                numberOfCorrect++;
                Toast.makeText(this, String.valueOf(numberOfCorrect), Toast.LENGTH_SHORT).show();
            } else {
                sharedPreferences.edit().putInt("numberofcorrect", numberOfCorrect).apply();
                startActivity(launchActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        } else if (alt2.getId() == v.getId()) {
            if (alt2.getText().equals(correctAnswer) ) {
                numberOfCorrect++;
            } else {
                sharedPreferences.edit().putInt("numberofcorrect", numberOfCorrect).apply();
                startActivity(launchActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        }

    }

    public Drawable makeDrawable(String name) {
        int resId = getResources().getIdentifier(name,"drawable", PlayQuizActivity.this.getPackageName());
        @SuppressLint("UseCompatLoadingForDrawables") Drawable d = PlayQuizActivity.this.getResources().getDrawable(resId);

        return d;
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return false;
    }


}