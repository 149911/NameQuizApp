package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import no.hvl.dat153.namequizapp.logic.Database;

public class MainActivity extends AppCompatActivity {

    private boolean dbMade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ((Database) getApplication()).createDatabase();
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dbMade = true;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ((Database) getApplication()).deleteDB();

    }

    public void showDatabase(View v) {
        Intent launchActivity = new Intent(MainActivity.this, DatabaseActivity.class);
        startActivity(launchActivity);
    }

    public void playQuiz(View v) {
        Intent launchActivity = new Intent(MainActivity.this, PlayQuizActivity.class);
        startActivity(launchActivity);
    }

}