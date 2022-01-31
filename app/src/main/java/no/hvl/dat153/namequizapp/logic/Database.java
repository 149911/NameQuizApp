package no.hvl.dat153.namequizapp.logic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.File;
import java.util.ArrayList;

public class Database {

    private ArrayList<ClassMate> classmatesDB;

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

    public void createDatabase() {
        classmatesDB = new ArrayList<ClassMate>();
    }


    @Override
    public String toString() {
        return "Database{" +
                "classmatesDB=" + classmatesDB +
                '}';
    }
}
