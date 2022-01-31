package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class PlayQuizActivity extends AppCompatActivity {

    private ArrayList<ClassMate> db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playquiz);

        if(getIntent().getParcelableArrayListExtra("db" ) != null) {
            db = getIntent().getParcelableArrayListExtra("db");
            Toast.makeText(PlayQuizActivity.this, db.size() + "", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent i = getIntent();
                ArrayList<ClassMate> dblist = (ArrayList<ClassMate>) i.getExtras().get("db");
                if (dblist == null) {
                    Toast.makeText(PlayQuizActivity.this, "FØKK", Toast.LENGTH_SHORT).show();
                } else {
                    for (ClassMate cm : dblist) {
                        System.out.println(cm.toString());
                    }
                }
            } catch (Exception ex) {
                String msg = ex.getMessage();
            }

        }


    }


}