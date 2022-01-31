package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("database", "hello shared message");
        editor.apply();
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