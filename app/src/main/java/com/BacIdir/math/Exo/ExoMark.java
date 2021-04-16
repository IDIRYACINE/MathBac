package com.BacIdir.math.Exo;

import android.content.ContentValues;
import android.content.Context;
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




       // for test only
       /*   List<String> testDeviceIds = Arrays.asList("F19072B8718F95EF9143056D67EBA41B");
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);*/


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
        Ad.Display();
        dismiss();
    }


    private void SaveMark(){
        RatingBar bar = this.findViewById(R.id.exo_star);
        float rating = bar.getRating();

        ContentValues exoMark = new ContentValues();
        exoMark.put("mark",rating);

        Database db = new Database(activity);
        db.Connect();

        boolean firstExoMark = db.UpdateData(Database.T[Registre.Unit],exoMark,Registre.Exo) == 0 ;
        if (firstExoMark){
            exoMark.put("exo",Registre.Exo);
            db.InsertData(Database.T[Registre.Unit],exoMark); 
        }
        else {db.UpdateData(Database.T[Registre.Unit],exoMark,Registre.Exo);}

        db.Disconect();

    }

}
