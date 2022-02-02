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

        TextView tv = findViewById(R.id.numberOfCorrect);
        SharedPreferences prefs = this.getSharedPreferences("no.hvl.dat153.namequizapp", MODE_PRIVATE);
        String points = String.valueOf(prefs.getInt("numberofcorrect", 0));

        tv.setText(points);

    }

    public void homePage(View v) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
