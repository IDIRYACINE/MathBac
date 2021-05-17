package com.BacIdir.math.Fragments.Units;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Customs.UnitButton;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.Fragments.INavigation;
import com.BacIdir.math.R;

public class UnitsAdapter extends RecyclerView.Adapter<UnitsAdapter.ViewHolder> implements View.OnClickListener  {

    private final Context context ;
    private final String[] Units ;
    private final INavigation parent ;

    public UnitsAdapter(Context context , String[] Units , INavigation parent) {
        this.context = context;
        this.Units = Units;
        this.parent = parent;
    }

    @NonNull
    @Override
    public UnitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View graph  = inflater.inflate(R.layout.blueprint_unit,parent,false);
        return new UnitsAdapter.ViewHolder(graph);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.unitButton.position = position ;
        holder.unitButton.setText(Units[position]);
        holder.unitButton.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        return Units.length;
    }

    @Override
    public void onClick(View v) {
        UnitButton unitButton = (UnitButton) v;
        Registre.currentUnit = unitButton.position;

        if(unitButton.position < 5 ) { parent.NavigateQuests();}
        else {parent.NavigateGraphs();}
    }


    public static class ViewHolder extends RecyclerView.ViewHolder  {
        UnitButton unitButton ;
        ViewHolder(View itemView) {
            super(itemView);
            unitButton = (UnitButton)itemView;

        }
    }

}
