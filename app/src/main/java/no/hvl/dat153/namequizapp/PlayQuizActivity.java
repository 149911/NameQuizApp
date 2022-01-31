package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.gson.Gson;

import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class PlayQuizActivity extends AppCompatActivity {

    private Database db = new Database();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        TextView tv = findViewById(R.id.text);
        tv.setText(((Database) getApplication()).getClassmatesDB().get(2).toString());

    }


}