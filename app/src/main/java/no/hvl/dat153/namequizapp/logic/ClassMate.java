package no.hvl.dat153.namequizapp.logic;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassMate implements Parcelable {

    private String sound;
    private String name;

    public ClassMate (String sound, String name) {
        this.sound = sound;
        this.name = name;
    }

    protected ClassMate(Parcel in) {
        sound = in.readString();
        name = in.readString();
    }

    public static final Creator<ClassMate> CREATOR = new Creator<ClassMate>() {
        @Override
        public ClassMate createFromParcel(Parcel in) {
            return new ClassMate(in);
        }

        @Override
        public ClassMate[] newArray(int size) {
            return new ClassMate[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(sound);
        parcel.writeString(name);
    }
}
