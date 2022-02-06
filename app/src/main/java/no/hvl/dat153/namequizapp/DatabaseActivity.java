package no.hvl.dat153.namequizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;

public class DatabaseActivity extends AppCompatActivity {

    private int i = 0;
    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
/*
        textView = findViewById(R.id.arraylistText);
        textView.setText(((Database) getApplication()).getClassmatesDB().get(i).getName());
        imageView = findViewById(R.id.imageViewClassmate);
        imageView.setImageDrawable(makeDrawable(((Database) getApplication()).getClassmatesDB().get(i).getName()));

 */




    }

    public Drawable makeDrawable(String name) {
        int resId = getResources().getIdentifier(name,"drawable", DatabaseActivity.this.getPackageName());
        @SuppressLint("UseCompatLoadingForDrawables") Drawable d = DatabaseActivity.this.getResources().getDrawable(resId);

        return d;
    }


    public void showDialogCameraOrStorage(View v) {
        Dialog d = onCreateDialog();
        d.show();
    }

    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DatabaseActivity.this);
        builder.setMessage(R.string.camera_or_storage).setPositiveButton(R.string.take_photo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DatabaseActivity.this, "Camera", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        }).setNegativeButton(R.string.picture_storage, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(intent);
            }
        });
        return builder.create();
    }


    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return false;
    }

}