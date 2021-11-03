package com.BacIdir.math.Exo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class ExoAdapter extends Adapter<ExoAdapter.ViewHolder>  {

    public int[] data ;
    private final Context context ;
    public ExoAdapter(Context context ,int[] data) {
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


