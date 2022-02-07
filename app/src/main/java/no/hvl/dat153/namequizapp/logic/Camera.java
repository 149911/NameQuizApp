package no.hvl.dat153.namequizapp.logic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera {

    private final int REQUEST_TAKE_PHOTO = 1;
    private Context context;
    private Activity activity;

    public Camera (Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            activity.startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    public String createFilename() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + "_";
        return imageFileName;
    }

    public File createImageFile(String path) throws IOException {
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES); // /storage/emulated/0/Android/data/
        File imageFile = File.createTempFile(path, ".jpg", storageDir); // Create file with random name
        return imageFile;
    }
}
