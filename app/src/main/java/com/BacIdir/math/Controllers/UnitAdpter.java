package com.BacIdir.math.Controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

import java.util.HashMap;

public class UnitAdpter extends BaseAdapter implements View.OnClickListener{

    private final String[] objects ;
    private final LayoutInflater inflater ;
    private final int nColumns ;
    private final NavController controller ;
    private final NavOptions navOptions ;
    public UnitAdpter(Context context ,NavController controller ,String[] objects ,int nColumns){
        this.inflater = LayoutInflater.from(context);
        this.objects = objects ;
        this.nColumns = nColumns ;
        this.controller = controller ;
        navOptions = new  NavOptions.Builder().setPopUpTo(R.id.exoQuest,true).build();
        SetUpDestinationTable();
    }

    @Override
    public int getCount() {
        return objects.length;
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

        int nRows = objects.length % nColumns == 0 ? objects.length /nColumns : (objects.length+1) / nColumns;
        int height = (parent.getHeight() - 40 ) / nRows;

        convertView = inflater.inflate(R.layout.blueprint_unit,parent,false);
        convertView.getLayoutParams().height = height;
        Integer pos = position ;
        convertView.setTag(pos);
        convertView.setOnClickListener(this);

        //if (position == objects.length - 1){convertView.getLayoutParams().width = parent.getWidth();}

        ImageView icon = convertView.findViewById(R.id.unit_icon);
        TextView title = convertView.findViewById(R.id.unit_title);
        icon.getLayoutParams().width = (parent.getWidth() - 10 ) / nColumns;
        icon.getLayoutParams().height = height / 2;

        title.setText(objects[position]);

        return convertView;
    }


    @Override
    public void onClick(View v) {
        Registre.Unit = (int) v.getTag();
        controller.navigate(TagToDestination(Registre.Unit),null,navOptions);
    }

    private HashMap<Integer,Integer> destinationTable ;
    private void SetUpDestinationTable (){
        HashMap<Integer, Integer> destinationTable = new HashMap<>();
        destinationTable.put(0, R.id.exoQuest);
        destinationTable.put(1, R.id.exoQuest);
        destinationTable.put(2, R.id.exoQuest);
        destinationTable.put(3, R.id.exoQuest);
        destinationTable.put(4, R.id.exoQuest);
        destinationTable.put(5, R.id.graphs);
        this.destinationTable = destinationTable ;
    }
    private int TagToDestination(int tag){
        return destinationTable.get(tag);
    }
}