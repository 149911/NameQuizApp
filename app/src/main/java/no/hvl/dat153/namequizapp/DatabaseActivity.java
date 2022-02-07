package no.hvl.dat153.namequizapp;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import no.hvl.dat153.namequizapp.logic.Camera;
import no.hvl.dat153.namequizapp.logic.ClassMate;
import no.hvl.dat153.namequizapp.logic.Database;
import no.hvl.dat153.namequizapp.logic.MyAdapter;

public class DatabaseActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int GALLERY_IMAGE = 2;

    private int i = 0;
    Camera camera;
    Button addBtn;
    Bitmap bm;
    ListView listView;
    Dialog d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        listView = findViewById(R.id.listview);

        addBtn = findViewById(R.id.addBtn);
        camera = new Camera(this, this);

        MyAdapter adapter = new MyAdapter(this, ((Database) getApplication()).getClassmatesDB());
        listView.setAdapter(adapter);

    }
    @Override
    public void onStop() {
        super.onStop();
        if (d != null) {
            d.dismiss();
            d = null;
        }
    }

    public void showDialogCameraOrStorage(View v) {
        d = onCreateDialog();
        d.show();
    }

    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DatabaseActivity.this);
        builder.setMessage(R.string.camera_or_storage).setPositiveButton(R.string.take_photo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        }).setNegativeButton(R.string.picture_storage, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, GALLERY_IMAGE);
            }
        });
        return builder.create();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri targetUri = null;

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            bm = (Bitmap) data.getExtras().get("data");
            ((Database) getApplication()).addClassMate(new ClassMate(bm, "From Camera"));
            startActivity(new Intent(DatabaseActivity.this, DatabaseActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            overridePendingTransition(0,0);
        }

        if(requestCode == GALLERY_IMAGE && resultCode == Activity.RESULT_OK) {
            try {
                targetUri = data.getData();
                bm = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));

                System.out.println( ((Database) getApplication()).getClassmatesDB().size() );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ((Database) getApplication()).addClassMate(new ClassMate(bm, "From Gallery"));
            startActivity(new Intent(DatabaseActivity.this, DatabaseActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            overridePendingTransition(0,0);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return false;
    }

}