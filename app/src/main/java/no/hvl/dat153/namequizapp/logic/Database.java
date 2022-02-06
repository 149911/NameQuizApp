package no.hvl.dat153.namequizapp.logic;

import android.app.Application;

import java.util.ArrayList;

public class Database extends Application {

    private ArrayList<ClassMate> classmatesDB = new ArrayList<>();
    private int numberOfCorrect;


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
        addClassMate(new ClassMate("meow","cat"));
        addClassMate(new ClassMate("neigh","horse"));
        addClassMate(new ClassMate("woof","dog"));
        addClassMate(new ClassMate("tspst","ferret"));

        Database db = new Database(classmatesDB);

        return db;
    }

    public void deleteDB() {
        classmatesDB = new ArrayList<>();
    }


    public void createInt() {
        numberOfCorrect = 0;
    }

    public int getInt() {
        return numberOfCorrect;
    }

    public void increaseInt() {
        numberOfCorrect++;
    }


    @Override
    public String toString() {
        return "Database{" +
                "classmatesDB=" + classmatesDB +
                '}';
    }
}
