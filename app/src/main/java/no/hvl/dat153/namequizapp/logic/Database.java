package no.hvl.dat153.namequizapp.logic;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import no.hvl.dat153.namequizapp.R;

public class Database extends Application {

    private ArrayList<ClassMate> classmatesDB = new ArrayList<>();
    private int numberOfCorrect;
    private int numberOfTries;
    //Context context;


    public Database (ArrayList<ClassMate> classmatesDB) {
        this.classmatesDB = classmatesDB;
    }

    public Database () {}

    public ArrayList<ClassMate> getClassmatesDB() {
        return classmatesDB;
    }

    public void setClassmatesDB(ArrayList<ClassMate> classmatesDB) {
        this.classmatesDB = classmatesDB;
    }

    public void addClassMate(ClassMate cm) {
        classmatesDB.add(cm);
    }

    public Database createDatabase() {

        addClassMate(new ClassMate(BitmapFactory.decodeResource(getResources(), R.drawable.cat),"cat"));
        addClassMate(new ClassMate(BitmapFactory.decodeResource(getResources(), R.drawable.horse),"horse"));
        addClassMate(new ClassMate(BitmapFactory.decodeResource(getResources(), R.drawable.dog),"dog"));
        addClassMate(new ClassMate(BitmapFactory.decodeResource(getResources(), R.drawable.ferret),"ferret"));

        Database db = new Database(classmatesDB);

        return db;
    }

    public void deleteDB() {
        classmatesDB = new ArrayList<>();
    }

    public void createNumberOfCorrect() {
        numberOfCorrect = 0;
    }

    public int getNumberOfCorrect() {
        return numberOfCorrect;
    }

    public void increaseNumberOfCorrect() {
        numberOfCorrect++;
    }

    public void resetCorrect() { numberOfCorrect=0; }

    public void createNumberOfTries() { numberOfTries = 0; }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void increaseNumberOfTries() {
        numberOfTries++;
    }


    @Override
    public String toString() {
        return "Database{" +
                "classmatesDB=" + classmatesDB +
                '}';
    }
}
