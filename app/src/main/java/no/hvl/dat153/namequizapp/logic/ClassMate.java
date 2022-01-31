package no.hvl.dat153.namequizapp.logic;

public class ClassMate {

    private String sound;
    private String name;

    public ClassMate (String sound, String name) {
        this.sound = sound;
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
