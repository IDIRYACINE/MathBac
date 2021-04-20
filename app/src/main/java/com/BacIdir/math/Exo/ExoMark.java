package com.BacIdir.math.Exo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.BacIdir.math.Controllers.AdMob;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;

public class ExoMark extends AlertDialog implements View.OnClickListener {

    private final Context activity ;
    private final AdMob Ad;


    public ExoMark(@NonNull Context context , AdMob Admob) {
        super(context);
        this.activity = context ;
        this.Ad = Admob;
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
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
        SaveMark();
        UpdateUnitProgress();
        Ad.Display();
        dismiss();
    }


    private void SaveMark(){
        Database db = new Database(activity);
        db.Connect();
        RatingBar markBar = findViewById(R.id.exo_star);
        db.SaveMark(markBar);
        db.Disconect();
    }
    private void UpdateUnitProgress(){
        boolean onLatestExo = Registre.currentExo + 1 > Registre.UnitsProgress[Registre.currentUnit]  ;
        if(onLatestExo){
            Registre.UnitsProgress[Registre.currentUnit] = Registre.currentExo + 1 ;
            ExoQuest exo = Registre.exoQuest ;
            exo.UpdateQuest(Registre.currentExo + 1);
            SharedPreferences settings = Registre.sharedPreferences;
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(Registre.UnitsProgressKeys[Registre.currentUnit],Registre.UnitsProgress[Registre.currentUnit]);
            editor.apply();


        }
    }

}
