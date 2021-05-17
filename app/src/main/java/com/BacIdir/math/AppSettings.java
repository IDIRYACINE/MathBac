package com.BacIdir.math;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.Data.Registre;
import com.BacIdir.math.Fragments.INavigation;
import com.BacIdir.math.Fragments.ViewFragment;

import static android.content.Context.MODE_PRIVATE;

public class AppSettings {
    private Activity activity ;
    private Looper looper ;
    private INavigation viewFragment ;

    public void SetUp(Activity activity){
        this.activity = activity ;
        SetUpSharedPref();
        Settings();
        CreateAdRequest();
    }

    private void Settings (){
        looper = activity.getMainLooper();
        Registre.lockedQuestColor = activity.getResources().getColor(R.color.colorBackground,null);
        Registre.unlockedQuestColor = activity.getResources().getColor(R.color.colorPrimary,null);
    }

    private void CreateAdRequest(){
        Runnable Ad = () -> {
           //AdMob Ad1 = new AdMob(activity);
           // Ad1.CreateAd();
            Handler handler = new Handler(looper);
            handler.post(() -> {
                activity.setContentView(R.layout.activity_main);
                SetUpViews();
            });
        };
        Thread Background = new Thread(Ad);
        Background.start();
    }

    private void SetUpSharedPref(){
        SharedPreferences settings = activity.getSharedPreferences("settings", MODE_PRIVATE);
        if (!settings.contains("initialized")){
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("initialized",true);
            editor.putInt("Unit1Progress",0);
            editor.putInt("Unit2Progress",0);
            editor.putInt("Unit3Progress",0);
            editor.putInt("Unit4Progress",0);
            editor.putInt("Unit5Progress",0);
            final DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            editor.putInt("ScreenWidth", displayMetrics.widthPixels);
            editor.putInt("ScreenHeight", displayMetrics.heightPixels);
            editor.apply();
        }
        Registre.sharedPreferences = settings ;
        LoadSharedPref(settings);
    }

    private void LoadSharedPref(SharedPreferences settings){
        for(int i = 0 ; i<5 ;i++) { Registre.UnitsProgress[i] = settings.getInt( Registre.UnitsProgressKeys[i], 0);
            Registre.SCREEN_WIDTH = settings.getInt("ScreenWidth",720);
            Registre.SCREEN_HEIGHT = settings.getInt("ScreenHeight",720);
        }
    }

    private void SetUpViews(){
        RecyclerView recyclerView = activity.findViewById(R.id.View_list);
        Registre.recyclerView = recyclerView ;
        TextView barTitle = activity.findViewById(R.id.app_bar_title);
        ImageView backButton = activity.findViewById(R.id.back_icon);
        backButton.setOnClickListener(v -> viewFragment.NavigateUnits());
        viewFragment = new ViewFragment(activity,recyclerView,barTitle,backButton);
        SetUpStartFragment();

    }

    private void SetUpStartFragment(){
        viewFragment.NavigateUnits();
    }

}
