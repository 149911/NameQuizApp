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
import no.hvl.dat153.namequizapp.logic.Quiz;

public class PlayQuizActivity extends AppCompatActivity {

    private ImageView imageView;
    private ArrayList<TextView> textViews = new ArrayList<>();
    private TextView alt1;
    private TextView alt2;
    private TextView alt3;
    private TextView alt4;
    private int numberOfCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        imageView = findViewById(R.id.imageQuiz);
        alt1 = findViewById(R.id.alt1);
        alt2 = findViewById(R.id.alt2);
        alt3 = findViewById(R.id.alt3);
        alt4 = findViewById(R.id.alt4);

        textViews.add(alt1);
        textViews.add(alt2);
        textViews.add(alt3);
        textViews.add(alt4);



        Quiz q = new Quiz();

        q.randomizeAnswers( new ArrayList<String>() {{add("Simen"); add("what"); add("mathilde"); add("eple");}}, "what", textViews );

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