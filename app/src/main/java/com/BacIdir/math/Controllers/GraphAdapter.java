package com.BacIdir.math.Controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.BacIdir.math.R;

public class GraphAdapter extends RecyclerView.Adapter<GraphAdapter.ViewHolder> {

    private LayoutInflater inflater ;
    private String[] data ;
    private float[] marks;

    public GraphAdapter(Context context , String[] data , float[] marks) {

        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.marks = marks ;
    }

    @NonNull
    @Override
    public GraphAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.blueprint_graph,parent,false);


        return new GraphAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.unit_title.setText(data[position]);
        holder.unit_rating.setRating(marks[position]);

    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView unit_title ;
        RatingBar unit_rating ;

        ViewHolder(View itemView) {
            super(itemView);
            unit_title = itemView.findViewById(R.id.UnitTitle);
            unit_rating = itemView.findViewById(R.id.UnitRating);


        }


    }

}
