package com.BacIdir.math.Controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import com.BacIdir.math.R;

public class GraphAdapter2 extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater ;
    private String[] data ;
    public float[] marks;



    public GraphAdapter2(Context context , String[] data , float[] marks) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.marks = marks ;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //nQuest % nColumns == 0 ? nQuest / nColumns : (nQuest + 1) / nColumns;
        int height = (parent.getHeight() - 77 ) / 5;
        convertView = inflater.inflate(R.layout.blueprint_graph,parent,false);
        convertView.getLayoutParams().height = height;
       TextView unit_title = convertView.findViewById(R.id.UnitTitle);
       RatingBar unit_rating = convertView.findViewById(R.id.UnitRating);

       unit_title.setText(data[position]);
       unit_rating.setRating(marks[position]);


        return convertView;
    }



}