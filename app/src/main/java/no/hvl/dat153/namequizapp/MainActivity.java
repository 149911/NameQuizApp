package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Database) getApplication()).createDatabase();
        ((Database) getApplication()).createNumberOfCorrect();
        ((Database) getApplication()).createNumberOfTries();



    }

    @Override
    protected void onRestart() {
        super.onRestart();

        ((Database) getApplication()).getClassmatesDB();
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
        if ( ((Database) getApplication()).getClassmatesDB().size() < 4 ) {
            Toast.makeText(this, "Need more entries in database", Toast.LENGTH_LONG).show();
        } else {
            startActivity(launchActivity);
        }
    }

}