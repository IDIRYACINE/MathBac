package com.BacIdir.math.Fragments.Graphs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class GraphAdapter extends RecyclerView.Adapter<GraphAdapter.ViewHolder>  {
    private final Context context ;
    private float[] marks ;

    public GraphAdapter(Context context,float[] marks) {
        this.context = context;
        this.marks = marks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View graph  = inflater.inflate(R.layout.blueprint_graph,parent,false);
        return new ViewHolder(graph);
    }

    @Override
    public void onBindViewHolder(@NonNull GraphAdapter.ViewHolder holder, int position) {
        holder.unitTitle.setText(Registre.unitsTitles[position]);
        holder.unitRating.setRating(marks[position]);
    }

    @Override
    public int getItemCount() {
        return marks.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView unitTitle ;
        RatingBar unitRating ;
        ViewHolder(View itemView) {
            super(itemView);
            unitTitle = itemView.findViewById(R.id.unit_title);
            unitRating = itemView.findViewById(R.id.unit_rating);

        }
    }

}