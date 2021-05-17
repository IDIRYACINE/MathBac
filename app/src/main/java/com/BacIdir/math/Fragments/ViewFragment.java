package com.BacIdir.math.Fragments;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Fragments.Quests.Quests;
import com.BacIdir.math.Fragments.Graphs.Graphs;
import com.BacIdir.math.Fragments.Units.Units;

public class ViewFragment implements INavigation {
    private final Context context ;
    private final RecyclerView viewList;
    private final TextView barTitle;
    private final ImageView backButton;

    public ViewFragment(Context context,RecyclerView viewList,TextView barTitle,ImageView backButton) {
        this.context = context;
        this.viewList = viewList ;
        this.backButton = backButton;
        this.barTitle = barTitle;
    }


    @Override
    public void NavigateUnits() {
        IFragmentView fragmentUnits = new Units(context , this);
        fragmentUnits.SetFragmentView(viewList,barTitle,backButton);
    }

    @Override
    public void NavigateGraphs() {
        IFragmentView fragmentGraphs = new Graphs(context );
        fragmentGraphs.SetFragmentView(viewList,barTitle,backButton);
    }

    @Override
    public void NavigateQuests() {
        IFragmentView fragmentQuests = new Quests(context );
        fragmentQuests.SetFragmentView(viewList,barTitle,backButton);
    }



}
