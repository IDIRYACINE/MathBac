package com.BacIdir.math.Exo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.BacIdir.math.Data.IUnitsData;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class ExoMark extends AlertDialog implements View.OnClickListener {

    private final Activity activity ;
    private final Exo exo ;

    public ExoMark(@NonNull Activity activity , Exo exo) {
        super(activity);
        this.activity = activity ;
        this.exo = exo ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogue_mark);
        Button yesButton = findViewById(R.id.btn_submit);
        yesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        IUnitsData.SaveExoMark(activity,findViewById(R.id.exo_star));
        UpdateUnitProgress();
        dismiss();
        exo.NextExo();
    }

    private void UpdateUnitProgress(){
        boolean onLatestExo = Registre.currentExo + 1 > Registre.UnitsProgress[Registre.currentUnit]  ;
        if(onLatestExo){
            Registre.UnitsProgress[Registre.currentUnit] = Registre.currentExo + 1 ;
            UpdateQuest();
            SharedPreferences settings = Registre.sharedPreferences;
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(Registre.UnitsProgressKeys[Registre.currentUnit],Registre.UnitsProgress[Registre.currentUnit]);
            editor.apply();
        }
    }

    private void UpdateQuest(){
        Registre.recyclerView.getChildAt(Registre.currentExo + 1).setBackgroundColor(Registre.unlockedQuestColor);
    }

}
