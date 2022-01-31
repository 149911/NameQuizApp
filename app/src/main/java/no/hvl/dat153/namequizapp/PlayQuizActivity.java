package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.gson.Gson;

import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class PlayQuizActivity extends AppCompatActivity {

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        db = new Database(getIntent().getParcelableArrayListExtra("db"));

        if(db != null) {
            Toast.makeText(PlayQuizActivity.this, "" + db.getClassmatesDB().size(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(PlayQuizActivity.this, "FØKK", Toast.LENGTH_SHORT).show();
        }


    }


}