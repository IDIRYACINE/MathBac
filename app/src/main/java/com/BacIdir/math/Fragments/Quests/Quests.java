package com.BacIdir.math.Fragments.Quests;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.Fragments.IFragmentView;
import com.BacIdir.math.R;

public class Quests implements IFragmentView {
    private final Context context ;
    private final QuestAdapter adpter ;

    public Quests(Context context) {
        this.context = context;
        int nQuest = Registre.Units[Registre.currentUnit].length ;
        adpter = new QuestAdapter(context, nQuest, 3);
    }

    private void SetUpBarTitle(TextView barTitle){
        barTitle.setText(context.getString(R.string.quest_bar_title));
    }


    @Override
    public void SetFragmentView(RecyclerView viewList, TextView barTitle, ImageView backButton) {
        viewList.setAdapter(adpter);
        viewList.setLayoutManager(new GridLayoutManager(context,3));
        backButton.setVisibility(View.VISIBLE);
        SetUpBarTitle(barTitle);
    }
}
