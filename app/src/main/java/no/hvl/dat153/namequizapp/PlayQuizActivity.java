package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;

import no.hvl.dat153.namequizapp.R;
import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class PlayQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("database", "");

        Toast.makeText(this, username.toString(), Toast.LENGTH_SHORT).show();
    }
}