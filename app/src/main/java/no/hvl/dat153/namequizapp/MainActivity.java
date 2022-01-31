package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;

import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class MainActivity extends AppCompatActivity {

    private Database db = new Database(new ArrayList<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = db.createDatabase();
    }

    public void showDatabase(View v) {
        Intent launchActivity = new Intent(MainActivity.this, DatabaseActivity.class);
        launchActivity.putParcelableArrayListExtra("db", db.getClassmatesDB());
        startActivity(launchActivity);
    }

    public void playQuiz(View v) {
        Intent launchActivity = new Intent(MainActivity.this, PlayQuizActivity.class);
        launchActivity.putParcelableArrayListExtra("db", db.getClassmatesDB());
        startActivity(launchActivity);
    }

}