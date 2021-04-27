package com.BacIdir.math.Controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class ExoAdapter extends Adapter<ExoAdapter.ViewHolder>  {

    private final LayoutInflater inflater ;
    public int[] data ;
    private Context context ;
    public ExoAdapter(Context context ,int[] data) {
        this.inflater = LayoutInflater.from(context);
        this.context = context ;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView view = new ImageView(context);
        view.setAdjustViewBounds(true);
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

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView exo_view ;
        ViewHolder(View itemView) {
            super(itemView);
            exo_view = (ImageView) itemView;
        }
    }



    }


