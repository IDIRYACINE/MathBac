package com.BacIdir.math.Fragments.Quests;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Customs.QuestView;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.ExoActivity;
import com.BacIdir.math.R;

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.ViewHolder> implements View.OnClickListener {

    private final Context context;
    private final int nQuest;
    private final RelativeLayout.LayoutParams params ;

    public QuestAdapter(Context context, int nQuest , int nColumns) {
        this.context = context;
        this.nQuest = nQuest;
        params = new RelativeLayout.LayoutParams((Registre.SCREEN_WIDTH - 160) / nColumns,(Registre.SCREEN_WIDTH - 160) / nColumns);
        params.setMargins(0,0,0,20);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View quest = inflater.inflate(R.layout.blueprint_quest,parent,false);
        return new ViewHolder(quest);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quest.setLayoutParams(params);
        holder.quest.setText(Integer.toString(position));
        holder.quest.position = position ;
        holder.quest.setOnClickListener(this);
        boolean exoUnlocked = position <= Registre.UnitsProgress[Registre.currentUnit] ;
        if(!exoUnlocked) {holder.quest.setBackgroundColor(Registre.lockedQuestColor);}
        else {holder.quest.setBackgroundColor(Registre.unlockedQuestColor);}

    }

    @Override
    public int getItemCount() {
        return nQuest;
    }

    @Override
    public void onClick(View v) {
        QuestView quest = (QuestView) v ;
        boolean exoUnlocked = quest.position <= Registre.UnitsProgress[Registre.currentUnit] ;
        if(exoUnlocked) {
            Registre.currentExo = quest.position  ;
            Intent intent = new Intent(context, ExoActivity.class);
            context.startActivity(intent);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        QuestView quest ;
        ViewHolder(View itemView) {
            super(itemView);
            quest = (QuestView) itemView;
        }
    }

}
