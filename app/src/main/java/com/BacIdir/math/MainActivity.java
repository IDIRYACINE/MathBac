package com.BacIdir.math;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.BacIdir.math.Controllers.AdMob;

public class MainActivity extends AppCompatActivity {

    private Activity activity ;
    private Looper looper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);
        activity = this ;
        looper = getMainLooper();
        Thread Background = new Thread(Ad);
        Background.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
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
