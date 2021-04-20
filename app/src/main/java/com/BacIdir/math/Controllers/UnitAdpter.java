package com.BacIdir.math.Controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

import java.util.HashMap;

public class UnitAdpter implements View.OnClickListener{

    private final String[] objects ;
    private final NavController controller ;
    private final NavOptions navOptions ;

    public UnitAdpter(Context context ,NavController controller ,String[] objects ,View root){
        this.objects = objects ;
        this.controller = controller ;
        navOptions = new  NavOptions.Builder().setPopUpTo(R.id.exoQuest,true).build();
        CreateUnits(LayoutInflater.from(context),root);
        SetUpDestinationTable();
    }

    private void CreateUnits(LayoutInflater inflater , View root){
        LinearLayout container = root.findViewById(R.id.unit_layout);
        for (int i = 0 ; i < objects.length ; i++) {
            View unit = inflater.inflate(R.layout.blueprint_unit, null, false);
            Button unitButton = unit.findViewById(R.id.unit_button);
            unitButton.setText(objects[i]);
            int UNIT_WIDTH = 600;
            unitButton.getLayoutParams().width = UNIT_WIDTH;
            unitButton.setTag(i);

            unitButton.setOnClickListener(this);

            container.addView(unit);
        }
    }

    @Override
    public void onClick(View v) {
        Registre.currentUnit = (int) v.getTag();
        controller.navigate(TagToDestination(Registre.currentUnit),null,navOptions);
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