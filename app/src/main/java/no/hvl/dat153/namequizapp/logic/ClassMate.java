package no.hvl.dat153.namequizapp.logic;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class ClassMate {

    private Bitmap image;
    private String name;

    public ClassMate (Bitmap image, String name) {
        this.image = image;
        this.name = name;
    }

    public ClassMate() {

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "The " + name + " says: " + (image == null);
    }
}
