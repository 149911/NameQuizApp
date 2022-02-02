package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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


    private Database db = new Database();
    private ImageView imageView;
    private TextView textView;
    private TextView alt1;
    private TextView alt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        View view = new View(getApplicationContext());

        correctOrWrong(view);

    }

   // public void playQuiz() {

   // }

    public String generateQuestionWithAnswer() {
        db.setClassmatesDB( ((Database) getApplication()).getClassmatesDB() );
        Random rand = new Random();
        int randomIndex = rand.nextInt(db.getClassmatesDB().size());

        String question = db.getClassmatesDB().get(randomIndex).getName();
        imageView = findViewById(R.id.imageQuiz);
        imageView.setImageDrawable(makeDrawable(question));

        textView = findViewById(R.id.text);
        textView.setText(((Database) getApplication()).getClassmatesDB().size()+ "");

        alt1 = findViewById(R.id.alternative1);
        alt2 = findViewById(R.id.alternative2);

        alt1.setText(question);

        ArrayList<String> alt = new ArrayList<>();
        db.getClassmatesDB().forEach(p -> alt.add(p.getName()));

        Random rand2 = new Random();
        int randomIndex2 = rand2.nextInt(alt.size());
        String alternative2 = alt.get(randomIndex2);

        if (randomIndex != randomIndex2) {
            alt2.setText(alternative2);
        } else {
            if (randomIndex2 == 0) {
                randomIndex2++;
            } else {
                randomIndex2--;
            }
            alternative2 = alt.get(randomIndex2);
            alt2.setText(alternative2);
        }

        return question;

    }


    public void correctOrWrong(View v) {
        String correctAnswer = generateQuestionWithAnswer();
        alt1 = findViewById(R.id.alternative1);
        alt2 = findViewById(R.id.alternative2);

        if (alt1.getId() == v.getId()) {
            if (alt1.getText().equals(correctAnswer) ) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show();
                Intent launchActivity = new Intent(PlayQuizActivity.this, ResultActivity.class);
                startActivity(launchActivity);
            }
        } else if (alt2.getId() == v.getId()) {
            if (alt2.getText().equals(correctAnswer) ) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show();
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