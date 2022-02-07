package no.hvl.dat153.namequizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView correct = findViewById(R.id.actuallyCorrect);
        TextView points = findViewById(R.id.numberOfCorrect);

        SharedPreferences prefs = this.getSharedPreferences("no.hvl.dat153.namequizapp", MODE_PRIVATE);
        String numberofcorrect = String.valueOf(prefs.getInt("numberofcorrect", 0));
        String actuallyCorrect = prefs.getString("correctAnswer", "");
        String yourGuess = prefs.getString("guess", "");

        correct.setText("The correct answer was: " + actuallyCorrect + "\n" + "Your answer was: " + yourGuess);
        points.setText("You got: " + numberofcorrect + " correct!");

    }

    public void homePage(View v) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
