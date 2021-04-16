package com.BacIdir.math.Controllers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.BacIdir.math.R;

public class ExoAdapter extends Adapter<ExoAdapter.ViewHolder>  {

    private LayoutInflater inflater ;
    private int[] data ;
    private Context context ;



    public ExoAdapter(Context context ,int[] data) {

        this.inflater = LayoutInflater.from(context);
        this.context = context ;
        this.data = data;
        //this.count = data.length ;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.blueprint_exo,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.exo_view.setImageResource(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    //*************************Scroll Listener*************************************************************************


    //*******************************View Holder CLass******************************************************************

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView exo_view ;

        ViewHolder(View itemView) {
            super(itemView);
            exo_view = itemView.findViewById(R.id.exo_hint);

        }


    }


    }


