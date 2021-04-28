package com.BacIdir.math;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.appcompat.app.AppCompatActivity;
import com.BacIdir.math.Controllers.AdMob;
import com.BacIdir.math.Data.Registre;

public class MainActivity extends AppCompatActivity {

    private Activity activity ;
    private Looper looper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);
        SharedPrefSetUp();
        Settings();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void Settings (){
        activity = this ;
        looper = getMainLooper();
        Registre.lockedQuestColor = getResources().getColor(R.color.colorBackground,null);
        Registre.unlockedQuestColor = getResources().getColor(R.color.colorPrimary,null);
        Thread Background = new Thread(Ad);
        Background.start();
    }
    private void SharedPrefSetUp (){
        SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
        if (!settings.contains("initialized")){
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("initialized",true);
            editor.putInt("Unit1Progress",0);
            editor.putInt("Unit2Progress",0);
            editor.putInt("Unit3Progress",0);
            editor.putInt("Unit4Progress",0);
            editor.putInt("Unit5Progress",0);
            final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
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

    Runnable Ad = new Runnable() {
        @Override
        public void run() {
            AdMob Ad = new AdMob(activity);
            Ad.CreateAd();
            Handler handler = new Handler(looper);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    setContentView(R.layout.activity_main);
                }});
        }
    };
}
