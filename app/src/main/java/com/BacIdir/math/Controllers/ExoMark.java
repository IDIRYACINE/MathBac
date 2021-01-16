package com.BacIdir.math.Controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.BacIdir.math.Data.Database;
import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.Arrays;
import java.util.List;

public class ExoMark extends AlertDialog implements View.OnClickListener {

    private Context activity ;
    private InterstitialAd mInterstitialAd;


    public ExoMark(@NonNull Context context , InterstitialAd mInterstitialAd) {
        super(context);
        this.activity = context ;
        this.mInterstitialAd = mInterstitialAd;
        //requestWindowFeature(Window.FEATURE_NO_TITLE);




       // for test only
         /* List<String> testDeviceIds = Arrays.asList("F19072B8718F95EF9143056D67EBA41B");
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);*/


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogue_mark);

        Button yes = findViewById(R.id.btn_submit);
        yes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_submit:
                Save();
                if (mInterstitialAd.isLoaded()) { mInterstitialAd.show(); }

                break;
        }
        dismiss();
    }


    private void Save(){

        Database db = new Database(activity);
        RatingBar bar = this.findViewById(R.id.exo_star);
        ContentValues values = new ContentValues();

        float rating = bar.getRating();

        values.put("mark",rating);

        db.Connect();



        if (db.UpdateData(Database.T[Registre.Unit],values,Registre.Exo) == 0){
            values.put("exo",Registre.Exo);
            db.InsertData(Database.T[Registre.Unit],values); }

        else {db.UpdateData(Database.T[Registre.Unit],values,Registre.Exo);}



        db.Disconect();






    }

}
