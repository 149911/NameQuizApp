package no.hvl.dat153.namequizapp.logic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import no.hvl.dat153.namequizapp.R;

public class MyAdapter extends ArrayAdapter<ClassMate> {

    private final Context context;
    private final ArrayList<ClassMate> bitmapValues;

    public MyAdapter(Context context, ArrayList<ClassMate> bitmapValues) {
        super(context, R.layout.rowlayout2, bitmapValues);
        this.context = context;
        this.bitmapValues = bitmapValues;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClassMate cm = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rowlayout2, parent, false);
        }

        ImageView imgCm = (ImageView) convertView.findViewById(R.id.icon);
        TextView imgLab = (TextView) convertView.findViewById(R.id.imgLabel);

        imgCm.setImageBitmap( cm.getImage() );

        imgLab.setText( cm.getName() );

        return convertView;
    }

    @Override
    public int getCount() {
        return bitmapValues.size();
    }
}
