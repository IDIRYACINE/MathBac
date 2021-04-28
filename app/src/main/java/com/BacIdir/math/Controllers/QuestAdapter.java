package com.BacIdir.math.Controllers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
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

        /*convertView = inflater.inflate(R.layout.blueprint_quest, parent, false);
        TextView quest = convertView.findViewById(R.id.quest_title);
        boolean exoUnlocked = position <= Registre.UnitsProgress[Registre.currentUnit] ;
        if(exoUnlocked){quest.setOnClickListener(this);}
        else {quest.setBackgroundColor(Registre.lockedQuestColor);}
        quest.getLayoutParams().width = (parent.getWidth() - 10) / nColumns;
        quest.getLayoutParams().height = (parent.getWidth() - 10) / nColumns;
        quest.setText(Integer.toString(position));
        quest.setTag(position);*/


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContextThemeWrapper themeContext = new ContextThemeWrapper(context, R.style.QuestView);
        QuestView quest  = new QuestView(themeContext);

        return new ViewHolder(quest);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quest.setLayoutParams(params);
        holder.quest.setText(Integer.toString(position));
        holder.quest.position = position ;
        boolean exoUnlocked = position <= Registre.UnitsProgress[Registre.currentUnit] ;
        if(exoUnlocked){holder.quest.setOnClickListener(this);}
        else {holder.quest.setBackgroundColor(Registre.lockedQuestColor);}

    }

    @Override
    public int getItemCount() {
        return nQuest;
    }

    @Override
    public void onClick(View v) {
        QuestView quest = (QuestView) v ;
        Registre.currentExo = quest.position  ;
        Intent intent = new Intent(context, ExoActivity.class);
        context.startActivity(intent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        QuestView quest ;
        ViewHolder(View itemView) {
            super(itemView);
            quest = (QuestView) itemView;
        }
    }

}
