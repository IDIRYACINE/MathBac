package com.BacIdir.math.Controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.ExoActivity;
import com.BacIdir.math.R;

public class QuestAdapter extends BaseAdapter implements View.OnClickListener {

    private final Context context;
    private final LayoutInflater inflater;
    private final int nQuest;
    private final int nColumns;


    public QuestAdapter(Context context, int nQuest , int nColumns) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.nQuest = nQuest;
        this.nColumns = nColumns;
    }

    @Override
    public int getCount() {
        return nQuest;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.blueprint_quest, parent, false);
        TextView quest = convertView.findViewById(R.id.quest_title);
        boolean exoUnlocked = position <= Registre.UnitsProgress[Registre.currentUnit] ;
        if(exoUnlocked){quest.setOnClickListener(this);}
        else {quest.setBackgroundColor(Registre.lockedQuestColor);}
        quest.getLayoutParams().width = (parent.getWidth() - 10) / nColumns;
        quest.getLayoutParams().height = (parent.getWidth() - 10) / nColumns;
        quest.setText(Integer.toString(position));
        quest.setTag(position);

        return convertView;
    }


    @Override
    public void onClick(View v) {
        Registre.currentExo = (Integer) v.getTag()  ;
        Intent intent = new Intent(context, ExoActivity.class);
        context.startActivity(intent);
    }






}