package com.BacIdir.math.Fragments.Graphs;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Data.IUnitsData;
import com.BacIdir.math.Fragments.IFragmentView;
import com.BacIdir.math.R;

public class Graphs implements IFragmentView {
    private final Context context;
    private final GraphAdapter adapter ;
    private float[] marks = new float[5];

    public Graphs(Context context) {
        this.context = context;
        adapter = new GraphAdapter(context,marks);
        GetUnitsData();
    }

    private void SetUpBarTitle(TextView barTitle){
        barTitle.setText(context.getString(R.string.graph_bar_title));
    }

    @Override
    public void SetFragmentView(RecyclerView viewList, TextView barTitle, ImageView backButton){
        viewList.setLayoutManager(new LinearLayoutManager(context));
        viewList.setAdapter(adapter);
        backButton.setVisibility(View.VISIBLE);
        SetUpBarTitle(barTitle);
    }

    private void GetUnitsData(){
        Runnable getUnitsData = () -> SetUpMarks();
        Thread Background = new Thread(getUnitsData);
        Background.start();
    }

    private void SetUpMarks(){
        IUnitsData.GetUnitData(marks,context);

    }

}
